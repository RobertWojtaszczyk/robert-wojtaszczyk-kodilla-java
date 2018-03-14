package com.kodilla.rps.game;

import com.kodilla.rps.game.definitions.CHOICE;

import java.util.Scanner;

public class UserDialogs {
    public static CHOICE readChoice(String name) {
        System.out.println("\n" + name + ", enter your choice:");
        System.out.println("1: ROCK \t2: PAPER \t 3: SCISSORS \t 4: SPOCK \t 5: LIZARD \t x: End of game \t n: New game");
        switch (getPlayerAnswer()) {
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
                return (areYouSure()) ? CHOICE.END : readChoice(name);
            case 'n':
                return (areYouSure()) ? CHOICE.NEW : readChoice(name);
        }
        System.out.println("Invalid input, try again...");
        return readChoice(name);
    }

    public static CHOICE readChoicePlayAgain(String name) {
        System.out.println("\n" + name + ", do You want to play again?");
        System.out.println("n: Play again \tx: End of game");
        switch (getPlayerAnswer()) {
            case 'x':
                return (areYouSure()) ? CHOICE.END : readChoicePlayAgain(name);
            case 'n':
                return CHOICE.AGAIN;
        }
        System.out.println("Invalid input, try again...");
        return readChoicePlayAgain(name);
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

    private static char getPlayerAnswer() {
        Scanner keyboardInput = new Scanner(System.in);
        return keyboardInput.next().toLowerCase().charAt(0);
    }

    public static String getPlayerName() {
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("\nROCK! \tPAPER! \tSCISSORS! \tand more... :)");
        System.out.print("Enter your name: ");
        return keyboardInput.nextLine();
    }

    public static int getNumberOfWins() {
        Scanner keyboardInput = new Scanner(System.in);
        System.out.print("Enter number of win rounds: ");
        return keyboardInput.hasNextInt() ? keyboardInput.nextInt() : getNumberOfWins();
    }

    public static void showFinalStats(Game game) {
        System.out.println("=========================\nNumber of rounds: " + game.getRoundCount());
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

    public static void showRoundStats(Game game) {
        System.out.println(game.getPlayer().getName() + ": " + game.getPlayersChoice());
        System.out.println(game.getComputer().getName() + ": " + game.getComputersChoice());
        System.out.println("Current score \n" + game.getPlayer().getName() + ": " + game.getPlayer().getScore() + "\nComputer: " + game.getComputer().getScore());
    }
}