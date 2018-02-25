package com.kodilla.rps.game;
import java.util.Scanner;

public class UserDialogs {
    public static CHOICE readChoice(String name) {
        System.out.println(name + ", enter your choice:");
        System.out.println("1: ROCK \t2: PAPER \t 3: SCISSORS \t x: End of game \t n: New game");
        Scanner keyboardInput = new Scanner(System.in);
        char playerKeyboardInput = keyboardInput.next().toLowerCase().charAt(0);
        switch (playerKeyboardInput) {
            case '1':
                return CHOICE.ROCK;
            case '2':
                return CHOICE.PAPER;
            case '3':
                return CHOICE.SCISSORS;
            case 'x':
                return CHOICE.END;
            case 'n':
                return CHOICE.NEW;
        }
        System.out.println("Invalid input, try again...");
        return readChoice(name);
    }

    public static String getPlayerName() {
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("ROCK \tPAPER \tSCISSORS");
        System.out.print("Enter your name: ");
        return keyboardInput.nextLine();
    }

    public static char waitForContinue() {
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Press any key to continue or 'x' to exit");
        String input = "";
        while (input.length()==0) {
            input = keyboardInput.nextLine();
        }
        return input.toLowerCase().charAt(0);
    }
}
