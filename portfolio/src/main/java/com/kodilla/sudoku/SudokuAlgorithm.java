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
        //rows
        for (int y = 0; y < 9; y++) {
            final int yy = y;
            for (int x = 0; x < 9; x++) {
                final int xx = x;
                if (sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getValue() != SudokuElement.EMPTY) {
                    if (sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().size() > 0) {
                        sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().clear();
                    }
                } else {
                    List<SudokuElement> currentColumn = new ArrayList<>();
                    for (int i = 0; i < 9; i++) {
                        currentColumn.add(sudokuBoard.getSudokuRows().get(i).getSudokuElements().get(yy));
                    }
                    // #1

                    //rows
                    List<Integer> newPossibleValues = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().stream()
                            .filter(possibleValue -> sudokuBoard.getSudokuRows().get(yy).getSudokuElements().stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .collect(Collectors.toList());
                    if (!newPossibleValues.equals(sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues())) {
                        actionPerformed = true;
                    }
                    sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setPossibleValues(newPossibleValues);

                    //columns

                    List<Integer> newPossibleValuesColumns = sudokuBoard.getSudokuRows().get(x).getSudokuElements().get(y).getPossibleValues().stream()
                            .filter(possibleValue -> currentColumn.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .collect(Collectors.toList());
                    if (!newPossibleValuesColumns.equals(sudokuBoard.getSudokuRows().get(x).getSudokuElements().get(y).getPossibleValues())) {
                        actionPerformed = true;
                    }
                    sudokuBoard.getSudokuRows().get(x).getSudokuElements().get(y).setPossibleValues(newPossibleValuesColumns);

                    // #2
                    //rows
                    List<Integer> elementsToPutInCurrentField = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().stream()
                            .filter(possibleValue -> sudokuBoard.getSudokuRows().get(yy).getSudokuElements().stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> sudokuBoard.getSudokuRows().get(yy).getSudokuElements().stream()
                                    .filter(sudokuElement -> !sudokuElement.equals(sudokuBoard.getSudokuRows().get(yy).getSudokuElements().get(xx)))
                                    .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream()).noneMatch(possibleValue::equals))
                            .collect(Collectors.toList());
                    if (elementsToPutInCurrentField.size() > 0) {
                        sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setValue(elementsToPutInCurrentField.get(0));
                        actionPerformed = true;
                    }

                    //columns
                    List<Integer> elementsToPutInCurrentFieldCol = sudokuBoard.getSudokuRows().get(x).getSudokuElements().get(y).getPossibleValues().stream()
                            .filter(possibleValue -> currentColumn.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> currentColumn.stream()
                                    .filter(sudokuElement -> !sudokuElement.equals(sudokuBoard.getSudokuRows().get(xx).getSudokuElements().get(yy)))
                                    .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream()).noneMatch(possibleValue::equals))
                            .collect(Collectors.toList());
                    if (elementsToPutInCurrentFieldCol.size() > 0) {
                        sudokuBoard.getSudokuRows().get(x).getSudokuElements().get(y).setValue(elementsToPutInCurrentFieldCol.get(0));
                        actionPerformed = true;
                    }

                    // #3
                    //rows
                    if (sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().size() == 1) {
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
                    }


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
        //columns

        //sections
        if (actionPerformed) {
            System.out.println("Action performed!");
        } else {
            System.out.println("No action!");
        }
        return actionPerformed;
    }
}