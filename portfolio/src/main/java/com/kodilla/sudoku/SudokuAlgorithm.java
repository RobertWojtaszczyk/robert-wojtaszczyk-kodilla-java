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
            final int yy = y;
            for (int x = 0; x < 9; x++) {
                final int xx = x;
                List<SudokuElement> currentColumn = new ArrayList<>();
                List<SudokuElement> currentSection = new ArrayList<>();
                for (int i = 0; i < 9; i++) {
                    currentColumn.add(sudokuBoard.getSudokuRows().get(i).getSudokuElements().get(yy));
                }
                int blockY = 3 * (y / 3);
                int blockX = 3 * (x / 3);
                for (int j = blockY; j < blockY + 3; j++) {
                    for (int i = blockX; i < blockX +3; i++) {
                        //System.out.println("Field: " + y + ":" + x + " -> Section coordinades: " + j + ":" + i);
                        currentSection.add(sudokuBoard.getSudokuRows().get(j).getSudokuElements().get(i));
                    }
                }
                if (sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getValue() != SudokuElement.EMPTY) {
                    if (sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().size() > 0) {
                        sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().clear();
                    }
                } else {
                    emptyFields++;


                    // #1

                    //rows
                    List<Integer> newPossibleValuesRows = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().stream()
                            .filter(possibleValue -> sudokuBoard.getSudokuRows().get(yy).getSudokuElements().stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .collect(Collectors.toList());
                    if (!newPossibleValuesRows.equals(sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues())) {
                        actionPerformed = true;
                    }
                    sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setPossibleValues(newPossibleValuesRows);

                    //columns
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
                    sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setPossibleValues(newPossibleValuesSections);


                    // #2
                    //rows
                    List<Integer> elementsToPutInCurrentField = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().stream()
                            .filter(possibleValue -> sudokuBoard.getSudokuRows().get(yy).getSudokuElements().stream()  //stream na wierszu
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> sudokuBoard.getSudokuRows().get(yy).getSudokuElements().stream()
                                    .filter(sudokuElement -> !sudokuElement.equals(sudokuBoard.getSudokuRows().get(yy).getSudokuElements().get(xx))) // odrzucamy bieżący element
                                    .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                                        .noneMatch(possibleValue::equals))
                            .collect(Collectors.toList());
                    if (elementsToPutInCurrentField.size() > 0) {
                        sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setValue(elementsToPutInCurrentField.get(0));
                        actionPerformed = true;
                    }

                    //columns
                    List<Integer> elementsToPutInCurrentFieldCol = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().stream()
                            .filter(possibleValue -> currentColumn.stream() //stream na kolumnie
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
                    }

                    // #3
                    //rows
                    /*if (sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().size() == 1) {
                        System.out.println("Warning: last possible valueX!"); // to remove
                        if (sudokuBoard.getSudokuRows().get(yy).getSudokuElements().stream()
                                .anyMatch(sudokuElement -> sudokuElement.getValue() == sudokuBoard.getSudokuRows().get(yy).getSudokuElements().get(xx).getPossibleValues().get(0)))
                            throw new SudokuAlgorithmException();
                    }
                    //columns
                    if (sudokuBoard.getSudokuRows().get(x).getSudokuElements().get(y).getPossibleValues().size() == 1) {
                        System.out.println("Warning: last possible valueY!"); // to remove
                        if (currentColumn.stream()
                                .anyMatch(sudokuElement -> sudokuElement.getValue() == sudokuBoard.getSudokuRows().get(xx).getSudokuElements().get(yy).getPossibleValues().get(0)))
                            throw new SudokuAlgorithmException();
                    }*/


                    // if last possible value put it to field value
                    if (sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().size() == 1) {
                        sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setValue(sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().get(0));
                        actionPerformed = true;
                    }
                }
                //to remove:
                /*for (Integer n : sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues()) {
                    System.out.println("wydruk kontrolny pola(warosc->y:x): " + n + "=" + y + ":" + x);
                }*/
            }
        }

        //sections
        System.out.println("Empty fields: " + emptyFields);
        if (actionPerformed) {
            System.out.println("Action performed!");
        } else {
            System.out.println("No action!");
        }
        return actionPerformed;
    }
}