package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuAlgorithm {
    private SudokuBoard sudokuBoard;

    public SudokuAlgorithm(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }
    public boolean resolveSudoku() throws SudokuAlgorithmException {
        boolean actionPerformed = false;
        int emptyFields = 0;
        //rows
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                List<SudokuElement> currentRow = new ArrayList<>(sudokuBoard.getSudokuRows().get(y).getSudokuElements());
                List<SudokuElement> currentColumn = new ArrayList<>();
                List<SudokuElement> currentSection = new ArrayList<>();
                SudokuElement currentElement = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x);

                for (int i = 0; i < 9; i++) {
                    currentColumn.add(sudokuBoard.getSudokuRows().get(i).getSudokuElements().get(y));
                }
                int blockY = 3 * (y / 3);
                int blockX = 3 * (x / 3);
                for (int j = blockY; j < blockY + 3; j++) {
                    for (int i = blockX; i < blockX +3; i++) {
                        currentSection.add(sudokuBoard.getSudokuRows().get(j).getSudokuElements().get(i));
                    }
                }

                if (currentElement.getValue() != SudokuElement.EMPTY) {
                    if (currentElement.getPossibleValues().size() > 0) {
                        currentElement.getPossibleValues().clear();
                    }
                } else {
                    emptyFields++;
                    // #1
                    List<Integer> newPossibleValues = currentElement.getPossibleValues().stream()
                            .filter(possibleValue -> currentRow.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> currentColumn.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> currentSection.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .collect(Collectors.toList());
                    if (!newPossibleValues.equals(currentElement.getPossibleValues())) {
                        currentElement.setPossibleValues(newPossibleValues);
                        actionPerformed = true;
                    }
                    /*//columns
                    List<Integer> newPossibleValuesColumns = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().stream()
                            .filter(possibleValue -> currentColumn.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .collect(Collectors.toList());
                    if (!newPossibleValuesColumns.equals(sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues())) {
                        actionPerformed = true;
                    }
                    sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setPossibleValues(newPossibleValuesColumns);

                    //sections
                    List<Integer> newPossibleValuesSections = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().stream()
                            .filter(possibleValue -> currentSection.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .collect(Collectors.toList());
                    if (!newPossibleValuesSections.equals(sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues())) {
                        actionPerformed = true;
                    }
                    sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setPossibleValues(newPossibleValuesSections);*/

                    // #2
                    List<Integer> elementsToPutInCurrentField = currentElement.getPossibleValues().stream()
                            .filter(possibleValue -> currentRow.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> currentRow.stream()
                                    .filter(sudokuElement -> !sudokuElement.equals(currentElement))
                                    .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                                        .noneMatch(possibleValue::equals))
                            .filter(possibleValue -> currentColumn.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> currentColumn.stream()
                                    .filter(sudokuElement -> !sudokuElement.equals(currentElement))
                                    .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                                        .noneMatch(possibleValue::equals))
                            .filter(possibleValue -> currentSection.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> currentSection.stream()
                                    .filter(sudokuElement -> !sudokuElement.equals(currentElement))
                                    .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                                        .noneMatch(possibleValue::equals))
                            .collect(Collectors.toList());
                    if (elementsToPutInCurrentField.size() > 0) {
                        currentElement.setValue(elementsToPutInCurrentField.get(0));
                        currentElement.getPossibleValues().clear();
                        actionPerformed = true;
                    }

                    /*//columns
                    List<Integer> elementsToPutInCurrentFieldCol = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().stream()
                            .filter(possibleValue -> currentColumn.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> currentColumn.stream()
                                    .filter(sudokuElement -> !sudokuElement.equals(sudokuBoard.getSudokuRows().get(yy).getSudokuElements().get(xx))) // odrzucamy bieżący element
                                    .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                                        .noneMatch(possibleValue::equals))
                            .collect(Collectors.toList());
                    if (elementsToPutInCurrentFieldCol.size() > 0) {
                        sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setValue(elementsToPutInCurrentFieldCol.get(0));
                        actionPerformed = true;
                    }
                    //sections
                    List<Integer> elementsToPutInCurrentFieldSec = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().stream()
                            .filter(possibleValue -> currentSection.stream() //stream na sekcji
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> currentSection.stream()
                                    .filter(sudokuElement -> !sudokuElement.equals(sudokuBoard.getSudokuRows().get(yy).getSudokuElements().get(xx))) // odrzucamy bieżący element
                                    .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                                    .noneMatch(possibleValue::equals))
                            .collect(Collectors.toList());
                    if (elementsToPutInCurrentFieldSec.size() > 0) {
                        sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setValue(elementsToPutInCurrentFieldSec.get(0));
                        actionPerformed = true;
                    }*/

                    // #3
                    if (currentElement.getPossibleValues().size() == 1) {
                        if (currentRow.stream()
                                .anyMatch(sudokuElement -> sudokuElement.getValue() == currentElement.getPossibleValues().get(0))) {
                            throw new SudokuAlgorithmException();
                        }
                        if (currentColumn.stream()
                                .anyMatch(sudokuElement -> sudokuElement.getValue() == currentElement.getPossibleValues().get(0))) {
                            throw new SudokuAlgorithmException();
                        }
                        if (currentSection.stream()
                                .anyMatch(sudokuElement -> sudokuElement.getValue() == currentElement.getPossibleValues().get(0))) {
                            throw new SudokuAlgorithmException();
                        }
                    }

                    // if last possible value put it to field value
                    if (currentElement.getPossibleValues().size() == 1) {
                        currentElement.setValue(currentElement.getPossibleValues().get(0));
                        currentElement.getPossibleValues().clear();
                        actionPerformed = true;
                    }
                }
            }
        }

        System.out.println("Empty fields: " + emptyFields);
        if (actionPerformed) {
            System.out.println("Action performed!");
        } else {
            System.out.println("No action!");
        }
        return actionPerformed;
    }
}