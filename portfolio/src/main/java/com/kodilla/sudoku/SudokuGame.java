package com.kodilla.sudoku;

import java.util.List;

public class SudokuGame {
    public static void main(String[] args) {
        boolean readyToSolve = false;
        int numberOfIterations = 0;
        SudokuBoard sudokuBoard = new SudokuBoard();
        System.out.println("Sudoku Solver");
        System.out.println(sudokuBoard);
        while (!readyToSolve) {
            String sudokuGivenNumbers = UserDialogs.getPlayerInput();
            if (sudokuGivenNumbers.equals("SUDOKU")) {
                readyToSolve = UserDialogs.checkSudokuBoard(sudokuBoard);
                SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(sudokuBoard);
                numberOfIterations = 0;
                boolean continueCalculations = readyToSolve;
                while (continueCalculations) {
                        continueCalculations = sudokuAlgorithm.resolveSudoku();
                        numberOfIterations++;
                }
            } else {
                List<Integer> userNumbers = UserDialogs.parseUserInput(sudokuGivenNumbers);
                if (userNumbers != null) {
                    for (int i = 0; i <= (userNumbers.size() - 3); i += 3) {
                        sudokuBoard
                                .getSudokuRows().get(userNumbers.get(i) - 1)
                                .getSudokuElements().get(userNumbers.get(i + 1) - 1)
                                .setValue(userNumbers.get(i + 2));
                    }
                    System.out.println(sudokuBoard);
                }
                UserDialogs.checkSudokuBoard(sudokuBoard);
            }
        }
        System.out.println("Number of iterations: " + numberOfIterations + "\n");
    }
}