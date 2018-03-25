package com.kodilla.sudoku;

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
                    .filter(n -> (n > 0 && n < 10))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Parameters must by a valid numbers: 1-9 separated with \",\"");
            return null;
        }
        if (userNumbers.size() % 3 == 0) {
            return userNumbers;
        } else {
            System.out.println("Wrong number of parameters or one of parameters out of range! Try again: numbers 1-9 separated with \",\"");
            return null;
        }
    }

    public static String getPlayerInput() {
        System.out.print("Enter numbers or SUDOKU to resolve sudoku: ");
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

    private static boolean areYouSure() {
        System.out.println("Are You sure? (y/n)");
        switch (getPlayerAnswer()) {
            case 'y':
                return true;
            case 'n':
                return false;
        }
        System.out.println("Invalid input, try again...");
        return areYouSure();
    }
}