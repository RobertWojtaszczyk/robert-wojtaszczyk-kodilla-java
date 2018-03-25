package com.kodilla.sudoku;

import java.util.List;

public class SudokuGame {
    public static void main(String[] args) {
        boolean gameFinished = false;
        boolean readyToSolve = false;
        SudokuBoard sudokuBoard = new SudokuBoard();
        System.out.println(sudokuBoard);
        while (!readyToSolve) {
            String sudokuGivenNumbers = UserDialogs.getPlayerInput();
            if (sudokuGivenNumbers.equals("SUDOKU")) {
                readyToSolve = true;
                SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(sudokuBoard);
                gameFinished = sudokuAlgorithm.resolveSudoku();
            } else {
                List<Integer> userNumbers = UserDialogs.parseUserInput(sudokuGivenNumbers);
                if (userNumbers != null) {
                    for (int i = 0; i <= (userNumbers.size() - 3); i += 3) {
                        sudokuBoard
                                .getSudokuRows().get(userNumbers.get(i) - 1)
                                .getSudokuElements().get(userNumbers.get(i + 1) - 1)
                                .setValue(userNumbers.get(i + 2));
                        sudokuBoard.getSudokuRows().get(userNumbers.get(i) - 1).getSudokuElements().get(userNumbers.get(i + 1) - 1).getPossibleValues().clear();
                    }
                    System.out.println(sudokuBoard);
                }
            }
        }
        System.out.println(sudokuBoard);
    }
}