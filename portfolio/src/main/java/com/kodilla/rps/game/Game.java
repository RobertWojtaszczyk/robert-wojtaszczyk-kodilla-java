package com.kodilla.rps.game;
import com.kodilla.rps.game.definitions.CHOICE;
import com.kodilla.rps.game.definitions.Cases;
import com.kodilla.rps.game.definitions.SCORE;

public class Game {
    private int roundCount;
    private Player player;
    private Player computer;
    private CHOICE playersChoice;
    private CHOICE computersChoice;
    private SCORE result;

    public Game(String name) {
        player = new Player(name);
        computer = new Player("Computer");
    }
    public int getRoundCount() {
        return roundCount;
    }
    public Player getPlayer() {
        return player;
    }
    public Player getComputer() {
        return computer;
    }
    public CHOICE playRound() {
        playersChoice = UserDialogs.readChoice(player.getName());
        if (playersChoice == CHOICE.END) {
            return CHOICE.END;
        }
        if (playersChoice == CHOICE.NEW) {
            return CHOICE.NEW;
        }
        computersChoice = computer.drawLots();
        cheatDrawLots(); // do some tricks
        System.out.println(player.getName() + ": " + playersChoice);
        System.out.println(computer.getName() + ": " + computersChoice);
        roundCount++;
        result = getResult();
        processResult();
        System.out.println("Current score \n" + player.getName() + ": " + player.getScore() + "\nComputer: " + computer.getScore());
        return CHOICE.AGAIN;
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
    /*public SCORE getResult() {
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
    }*/
    public SCORE getResult() {
        if (playersChoice != computersChoice) {
            return Cases.getCases().stream()
                    .filter(cases -> cases.getPlayersChoice().equals(playersChoice) && cases.getComputersChoice().equals(computersChoice))
                    .findFirst()
                    //ifPresent(cases -> getResult())  ????error
                    .get()
                    .getResult();
        }
        return SCORE.TIE;
    }
    public void cheatDrawLots() {
        int alteredChance = computer.alterComputerChance();
        System.out.println("Altered chance: " + alteredChance);
        alteredChance = alteredChance == 3 ? 2 : alteredChance;
        switch (alteredChance) {
            case 0:
                if (playersChoice != computersChoice) {
                    System.out.println("Giving another chance for a TIE! Computer choice was: " + computersChoice);
                    computersChoice = computer.drawLots();// or chose proper result for computer?
                }
                return;
            case 1:
                if (getResult() == SCORE.COMPUTER || getResult() == SCORE.TIE) {
                    System.out.println("It would be TIE or Computer(" + computersChoice + ") would win! Giving player(" + playersChoice + ") another chance!");
                    computersChoice = computer.drawLots();// or chose proper result for computer?
                }
                return;
            case 2:
                if (getResult() == SCORE.PLAYER || getResult() == SCORE.TIE) {
                    System.out.println("It would be TIE or Player (" + playersChoice + ")would win! Giving computer(" + computersChoice + ") another chance!");
                    computersChoice = computer.drawLots();// or chose proper result for computer?
                }
                return;
        }
    }
}