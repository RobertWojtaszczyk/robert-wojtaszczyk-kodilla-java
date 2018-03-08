package com.kodilla.rps.game;
import com.kodilla.rps.game.definitions.CHOICE;
import com.kodilla.rps.game.definitions.Cases;
import com.kodilla.rps.game.definitions.SCORE;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private int roundCount;
    private int numberOfWins;
    private Player player;
    private Player computer;
    private CHOICE playersChoice;
    private CHOICE computersChoice;
    private SCORE result;

    public Game(String name, int numberOfWins) {
        player = new Player(name);
        computer = new Player("Computer");
        this.numberOfWins = numberOfWins;
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
    public CHOICE getPlayersChoice() {
        return playersChoice;
    }
    public CHOICE getComputersChoice() {
        return computersChoice;
    }

    public CHOICE playRound(CHOICE playersChoice) {
        this.playersChoice = playersChoice;
        computersChoice = cheatDrawLots();
        result = getResult();
        processResult();
        roundCount++;
        return ((player.getScore() > computer.getScore()) ? player.getScore() : computer.getScore()) >= numberOfWins ? CHOICE.WIN : CHOICE.CONTINUE; //?oddzielna metoda obliczająca i zwracająca wynik?
    }

    private void processResult() {
        switch (result) {
            case PLAYER:
                player.setScore();
                break;
            case COMPUTER:
                computer.setScore();
                break;
            case TIE:
                System.out.println("It is a TIE!");
        }
    }

    private SCORE getResult() {
        if (playersChoice != computersChoice) {
            return Cases.getCases().stream()
                    .filter(cases -> cases.getPlayersChoice().equals(playersChoice) && cases.getComputersChoice().equals(computersChoice))
                    .findFirst()
                    .get() // ???
                    .getResult();
        }
        return SCORE.TIE;
    }

    private CHOICE setResult(SCORE score, int alteredChance) {
        List<Cases> choices = Cases.getCases().stream()
                .filter(cases -> cases.getPlayersChoice().equals(playersChoice) && cases.getResult().equals(score))
                .collect(Collectors.toList());
        return    (alteredChance >= 25 && alteredChance < 37) ? choices.get(0).getComputersChoice()
                : (alteredChance >= 37 && alteredChance < 50) ? choices.get(1).getComputersChoice()
                : (alteredChance >= 50 && alteredChance < 75) ? choices.get(0).getComputersChoice()
                :  choices.get(1).getComputersChoice();
    }

    private CHOICE cheatDrawLots() {
        int alteredChance = computer.alterComputerChance();
        return    (alteredChance > 0 && alteredChance < 25) ? playersChoice
                : (alteredChance >= 25 && alteredChance < 50) ? setResult(SCORE.PLAYER, alteredChance)
                : setResult(SCORE.COMPUTER, alteredChance);
    }
}