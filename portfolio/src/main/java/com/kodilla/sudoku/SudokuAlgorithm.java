package com.kodilla.sudoku;

import java.util.List;
import java.util.stream.Collectors;

public class SudokuAlgorithm {
    SudokuBoard sudokuBoard;

    public SudokuAlgorithm(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }
    public boolean resolveSudoku() {
        //rows
        for (int y = 0; y < 9; y++) {
            final int yy = y; //????
            for (int x = 0; x < 9; x++) {
                final int xx = x;  //????
                if (sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getValue() == SudokuElement.EMPTY) {
                    // #1
                    List<Integer> newPossibleValues = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().stream()
                            .filter(possibleValue -> sudokuBoard.getSudokuRows().get(yy).getSudokuElements().stream().noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .collect(Collectors.toList());
                    sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setPossibleValues(newPossibleValues);

                    if (sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().size() == 1) {
                        sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setValue(sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().get(0));
                    }
                    // #2
                    List<Integer> elementsToPutInCurrentField = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().stream()
                            .filter(possibleValue -> sudokuBoard.getSudokuRows().get(yy).getSudokuElements().stream().noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> sudokuBoard.getSudokuRows().get(yy).getSudokuElements().stream()
                                    .filter(sudokuElement -> !sudokuElement.equals(sudokuBoard.getSudokuRows().get(yy).getSudokuElements().get(xx)))
                                    .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream()).noneMatch(possibleValue::equals))
                            .collect(Collectors.toList());
                    if (elementsToPutInCurrentField.size() > 0) {
                        sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).setValue(elementsToPutInCurrentField.get(0));
                    }
                    // #3




                    /*List<Integer> numbersToRemove = new ArrayList<>();
                    for (Integer n : sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues()) {
                        if (checkIfNumberIsPresentElsewhere(n, x, y)) {
                            System.out.println("usuwanie elementu: [" + n + "] z pola: " + y + "|" + x); // to remove
                            int index = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().indexOf(n);
                            numbersToRemove.add(sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().get(index));
                        }
                    }
                    sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().removeAll(numbersToRemove);*/
                } else {
                    sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues().clear(); //???? czy czyścić tablicę?
                    System.out.println("field: " + y + ":" + x + " is not empty"); // to remove
                }
                //to remove:
                for (Integer n : sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getPossibleValues()) {
                    System.out.println("wydruk kontrolny pola(warosc->y:x): " + n + "=" + y + ":" + x);
                }
            }
        }
        //columns

        //sections

        return true;
    }

    /*public boolean checkIfNumberIsPresentElsewhere(int n, int x, int y)
    {
        boolean result = false;
        for (int i = 0; i < 9; i++) {
            if (sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(i).getValue() == n) {
                result = true;
            }
        }
        return result;
    }*/
}