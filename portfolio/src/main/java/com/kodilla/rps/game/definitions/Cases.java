package com.kodilla.rps.game.definitions;
import java.util.ArrayList;
import java.util.List;

public final class Cases {
    private CHOICE playersChoice;
    private CHOICE computersChoice;
    private SCORE result;

    public Cases(CHOICE playersChoice, CHOICE computersChoice, SCORE result) {
        this.playersChoice = playersChoice;
        this.computersChoice = computersChoice;
        this.result = result;
    }

    public CHOICE getPlayersChoice() {
        return playersChoice;
    }

    public CHOICE getComputersChoice() {
        return computersChoice;
    }

    public SCORE getResult() {
        return result;
    }

    public static List<Cases> getCases() {
        final List<Cases> cases = new ArrayList<>();
        cases.add(new Cases(CHOICE.ROCK, CHOICE.SCISSORS, SCORE.PLAYER));
        cases.add(new Cases(CHOICE.ROCK, CHOICE.LIZARD, SCORE.PLAYER));
        cases.add(new Cases(CHOICE.ROCK, CHOICE.PAPER, SCORE.COMPUTER));
        cases.add(new Cases(CHOICE.ROCK, CHOICE.SPOCK, SCORE.COMPUTER));
        cases.add(new Cases(CHOICE.PAPER, CHOICE.ROCK, SCORE.PLAYER));
        cases.add(new Cases(CHOICE.PAPER, CHOICE.SPOCK, SCORE.PLAYER));
        cases.add(new Cases(CHOICE.PAPER, CHOICE.SCISSORS, SCORE.COMPUTER));
        cases.add(new Cases(CHOICE.PAPER, CHOICE.LIZARD, SCORE.COMPUTER));
        cases.add(new Cases(CHOICE.SCISSORS, CHOICE.PAPER, SCORE.PLAYER));
        cases.add(new Cases(CHOICE.SCISSORS, CHOICE.LIZARD, SCORE.PLAYER));
        cases.add(new Cases(CHOICE.SCISSORS, CHOICE.ROCK, SCORE.COMPUTER));
        cases.add(new Cases(CHOICE.SCISSORS, CHOICE.SPOCK, SCORE.COMPUTER));
        cases.add(new Cases(CHOICE.SPOCK, CHOICE.SCISSORS, SCORE.PLAYER));
        cases.add(new Cases(CHOICE.SPOCK, CHOICE.ROCK, SCORE.PLAYER));
        cases.add(new Cases(CHOICE.SPOCK, CHOICE.PAPER, SCORE.COMPUTER));
        cases.add(new Cases(CHOICE.SPOCK, CHOICE.LIZARD, SCORE.COMPUTER));
        cases.add(new Cases(CHOICE.LIZARD, CHOICE.SPOCK, SCORE.PLAYER));
        cases.add(new Cases(CHOICE.LIZARD, CHOICE.PAPER, SCORE.PLAYER));
        cases.add(new Cases(CHOICE.LIZARD, CHOICE.ROCK, SCORE.COMPUTER));
        cases.add(new Cases(CHOICE.LIZARD, CHOICE.SCISSORS, SCORE.COMPUTER));
        return new ArrayList<>(cases);
    }
}
