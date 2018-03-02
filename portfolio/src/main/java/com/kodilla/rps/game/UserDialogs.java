package com.kodilla.rps.game;
import com.kodilla.rps.game.definitions.CHOICE;

import java.util.Scanner;

public class UserDialogs {
    public static CHOICE readChoice(String name) {
        System.out.println(name + ", enter your choice:");
        System.out.println("1: ROCK \t2: PAPER \t 3: SCISSORS \t 4: SPOCK \t 5: LIZARD \t x: End of game \t n: New game");
        Scanner keyboardInput = new Scanner(System.in);
        char playerKeyboardInput = keyboardInput.next().toLowerCase().charAt(0);
        switch (playerKeyboardInput) {
            case '1':
                return CHOICE.ROCK;
            case '2':
                return CHOICE.PAPER;
            case '3':
                return CHOICE.SCISSORS;
            case '4':
                return CHOICE.SPOCK;
            case '5':
                return CHOICE.LIZARD;
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
        System.out.println("ROCK! \tPAPER! \tSCISSORS! \t:)");
        /*for (CHOICE choice : CHOICE.values()) {
            System.out.print(choice + "! \t");
        }*/
        System.out.print("\nEnter your name: ");
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
    public static void showFinalStats(Game game) {
        System.out.println("Number of rounds: " + game.getRoundCount());
        System.out.println("Player " + game.getPlayer().getName() + ": " + game.getPlayer().getScore());
        System.out.println("Computer wins: " + game.getComputer().getScore());
        System.out.println("Number of ties: " + (game.getRoundCount() - game.getComputer().getScore() - game.getPlayer().getScore()));
        if (game.getComputer().getScore() == game.getPlayer().getScore()) {
            System.out.println("There is no winner. It's a TIE!");
        } else {
            String winner = game.getComputer().getScore() > game.getPlayer().getScore() ? "COMPUTER" : "PLAYER: " + game.getPlayer().getName();
            System.out.println("The WINNER is " + winner + "!");
        }
    }
}