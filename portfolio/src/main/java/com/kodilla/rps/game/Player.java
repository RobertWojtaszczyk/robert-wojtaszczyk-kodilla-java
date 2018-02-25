package com.kodilla.rps.game;
import java.util.Random;

public class Player {
    private String name;
    private int score;
    Random generator = new Random();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score += 1;
    }

    public CHOICE drawLots () {
        int choice = generator.nextInt(3);
        return CHOICE.values()[choice];
    }
}
