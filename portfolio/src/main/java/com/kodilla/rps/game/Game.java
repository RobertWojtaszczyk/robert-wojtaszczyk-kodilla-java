package com.kodilla.rps.game;

public class Game {
    private String playerName;
    private int roundCount;
    private Player player;
    private Player computer;
    private CHOICE playersChoice;
    private CHOICE computersChoice;
    private SCORE result;
    public Game(String name) {
        this.playerName = name;
    }
    public int getRoundCount() {
        return roundCount;
    }
    public int getPlayerScore() { //????????? getter do gettera?
        return player.getScore();
    }
    public int getComputerScore() { //?????????
        return computer.getScore();
    }
    public String getPlayerName() { //?????????
        return playerName;
    }
    public void initializeGame() {
        player = new Player(playerName);
        computer = new Player("Computer");
    }
    public void playRound() {
        playersChoice = UserDialogs.readChoice(playerName);
        computersChoice = computer.drawLots();
        System.out.println(player.getName() + ": " + playersChoice);
        System.out.println(computer.getName() + ": " + computersChoice);
        roundCount++;
        result = result(); // ?result = result()?
        processResult();
        System.out.println("Current score \n" + player.getName() + ": " + player.getScore() + "\nComputer: " + computer.getScore());
    }
    public void processResult() {
        switch (result) {
            case PLAYER:
                System.out.println(player.getName() + " gets score");
                player.setScore();
                return;
            case COMPUTER:
                System.out.println("Computer gets score");
                computer.setScore();
                return;
            case TIE:
                System.out.println("It is a TIE!");
                return;
        }
    }
    public SCORE result() {
        if (playersChoice != computersChoice) {
                switch (playersChoice) {
                    case PAPER:
                        return computersChoice == CHOICE.ROCK ? SCORE.PLAYER : SCORE.COMPUTER;
                    case ROCK:
                        return computersChoice == CHOICE.SCISSORS ? SCORE.PLAYER : SCORE.COMPUTER;
                    case SCISSORS:
                        return computersChoice == CHOICE.PAPER ? SCORE.PLAYER : SCORE.COMPUTER;
                }
        }
        return SCORE.TIE;
    }
}