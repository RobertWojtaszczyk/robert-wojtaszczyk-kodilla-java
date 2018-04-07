package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserDialogs {

    public static List<Integer> parseUserInput(String sudokuGivenNumbers) {
        List<Integer> userNumbers;
        try {
            userNumbers = Arrays.stream(sudokuGivenNumbers.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .filter(n -> (n >= 0 && n < 10))
                    .map(n -> (n.equals(0)) ? SudokuElement.EMPTY : n)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Parameters must be a valid numbers: 1-9 separated with \",\"");
            return null;
        }
        if (userNumbers.size() % 3 == 0) {
            int numberOfIterations = 1;
            for (Integer userNumber : userNumbers) {
                if (numberOfIterations % 3 != 0) {
                    if (userNumber < 1) {
                        System.out.println("Invalid field coordinates!");
                        return null;
                    }
                }
                numberOfIterations++;
            }
            return userNumbers;
        } else {
            System.out.println("Wrong number of parameters or one of parameters out of range! Try again.");
            return null;
        }
    }

    public static String getPlayerInput() {
        System.out.print("Enter Row,Column,Value - numbers between 1-9 and separated with \",\" \n" +
                "You can enter multiple sets of values, as many You want, for example: 1,1,1,2,2,2,3,3,3\n" +
                "To clear field enter coordinates and value 0 with the same schema: Row,Column,0\n" +
                "To correct wrong value, just enter coordinates and new value\n" +
                "When done with given numbers, enter SUDOKU to resolve sudoku: ");
        Scanner keyboardInput = new Scanner(System.in);
        String input = keyboardInput.nextLine().toUpperCase();
        if (input.equals("SUDOKU")) {
            return input;
        }
        if (input.length() > 4) {
            return input;
        } else {
            System.out.println("Invalid input, try again...");
            return getPlayerInput();
        }
    }

    private static char getPlayerAnswer() {
        Scanner keyboardInput = new Scanner(System.in);
        return keyboardInput.next().toLowerCase().charAt(0);
    }

    private static boolean yesNo() {
        System.out.print("(y/n)");
        switch (getPlayerAnswer()) {
            case 'y':
                return true;
            case 'n':
                return false;
        }
        System.out.println("Invalid input, try again...");
        return yesNo();
    }

    public static boolean resolveAnotherSudoku() {
        System.out.println("Would You like to try another Sudoku?");
        return yesNo();
    }

    public static boolean sudokuBoardValidator(SudokuBoard sudokuBoard) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                SudokuElement currentElement = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x);
                List<SudokuElement> currentRow = new ArrayList<>(sudokuBoard.getSudokuRows().get(y).getSudokuElements());
                List<SudokuElement> currentColumn = new ArrayList<>();
                for (int i = 0; i < 9; i++) {
                    currentColumn.add(sudokuBoard.getSudokuRows().get(i).getSudokuElements().get(x));
                }
                List<SudokuElement> currentSection = new ArrayList<>();
                int blockY = 3 * (y / 3);
                int blockX = 3 * (x / 3);
                for (int j = blockY; j < blockY + 3; j++) {
                    for (int i = blockX; i < blockX + 3; i++) {
                        currentSection.add(sudokuBoard.getSudokuRows().get(j).getSudokuElements().get(i));
                    }
                }

                if (currentElement.getValue() != SudokuElement.EMPTY) {
                    int numberOfDoubledValues;
                    numberOfDoubledValues = currentRow.stream()
                            .filter(sudokuElement -> !sudokuElement.equals(currentElement))
                            .filter(sudokuElement -> sudokuElement.getValue() == currentElement.getValue())
                            .map(sudokuElement -> 1)
                            .reduce(0, (sum, current) -> sum = sum + current);
                    numberOfDoubledValues += currentColumn.stream()
                            .filter(sudokuElement -> !sudokuElement.equals(currentElement))
                            .filter(sudokuElement -> sudokuElement.getValue() == currentElement.getValue())
                            .map(sudokuElement -> 1)
                            .reduce(0, (sum, current) -> sum = sum + current);
                    numberOfDoubledValues += currentSection.stream()
                            .filter(sudokuElement -> !sudokuElement.equals(currentElement))
                            .filter(sudokuElement -> sudokuElement.getValue() == currentElement.getValue())
                            .map(sudokuElement -> 1)
                            .reduce(0, (sum, current) -> sum = sum + current);

                    if (numberOfDoubledValues > 0) {
                        System.out.println("\nInvalid input data! Check Your Sudoku numbers again!\n");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void fillSudokuBoard(List<Integer> userNumbers, SudokuBoard sudokuBoard) {
        if (userNumbers != null) {
            for (int i = 0; i <= (userNumbers.size() - 3); i += 3) {
                sudokuBoard
                        .getSudokuRows().get(userNumbers.get(i) - 1)
                        .getSudokuElements().get(userNumbers.get(i + 1) - 1)
                        .setValue(userNumbers.get(i + 2));
            }
            System.out.println(sudokuBoard);
            UserDialogs.sudokuBoardValidator(sudokuBoard);
        }
    }
}