package com.kodilla.rps.game;
import java.util.Random;

public class Player {
    private String name;
    private int score;
    private Random generator = new Random();

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
        System.out.println(name + " gets score!");
    }

    public int alterComputerChance() {
        return generator.nextInt(100) + 1;
    }
}
