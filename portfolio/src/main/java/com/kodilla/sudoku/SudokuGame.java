package com.kodilla.sudoku;

import java.util.List;

public class SudokuGame {
    public static void main(String[] args) {
        boolean continueProgram = true;
        while (continueProgram) {
            boolean readyToSolve = false;
            SudokuBoard sudokuBoard = new SudokuBoard();
            System.out.println("#Sudoku Solver#");
            System.out.println(sudokuBoard);
            while (!readyToSolve) {
                String sudokuGivenNumbers = UserDialogs.getPlayerInput();
                if (sudokuGivenNumbers.equals("SUDOKU")) {
                    Algorithm algorithm = new Algorithm(sudokuBoard);
                    readyToSolve = algorithm.validateBoardValues();
                    boolean continueCalculations = readyToSolve;
                    while (continueCalculations) {
                        continueCalculations = algorithm.resolveSudoku();
                    }
                } else {
                    List<Integer> userNumbers = UserDialogs.parseUserInput(sudokuGivenNumbers);
                    UserDialogs.fillSudokuBoard(userNumbers, sudokuBoard);
                }
            }
            continueProgram = UserDialogs.resolveAnotherSudoku();
        }
    }
}