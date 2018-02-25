package com.kodilla.rps.game;

public class Game {
    private String playerName;
    private int roundCount;
    private Player player;
    private Player computer;
    private CHOICE playersChoice;
    private CHOICE computersChoice;
    public Game(String name) {
        this.playerName = name;
    }
    public int getRoundCount() {
        return roundCount;
    }
    public void initializeGame() {
        player = new Player(playerName);
        computer = new Player("Computer");
    }
    public void playRound() {
        System.out.println("Current score \n" + player.getName() + ": " + player.getScore() + "\nComputer: " + computer.getScore());
        playersChoice = UserDialogs.readChoice(playerName);
        computersChoice = computer.drawLots();
        System.out.println(player.getName() + ": " + playersChoice);
        System.out.println(computer.getName() + ": " + computersChoice);
        roundCount++;
        result();
        System.out.println("Current score \n" + player.getName() + ": " + player.getScore() + "\nComputer: " + computer.getScore());
    }
    public void result() {
        if (playersChoice != computersChoice) {
                switch (playersChoice) {
                    case PAPER:
                        if (computersChoice == CHOICE.ROCK) {
                            System.out.println("Player gets score for paper");
                            player.setScore();
                        } else {
                            System.out.println("Computer gets score for paper");
                            computer.setScore();
                        }
                        return;
                    case ROCK:
                        if (computersChoice == CHOICE.SCISSORS) {
                            System.out.println("Player gets score for rock");
                            player.setScore();
                        } else {
                            System.out.println("Computer gets score for rock");
                            computer.setScore();
                        }
                        return;
                    case SCISSORS:
                        if (computersChoice == CHOICE.PAPER) {
                            System.out.println("Player gets score for scissors");
                            player.setScore();
                        } else {
                            System.out.println("Computer gets score for scissors");
                            computer.setScore();
                        }
                        return;
                }
        }
    }
}