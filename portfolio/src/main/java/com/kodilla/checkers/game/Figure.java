package com.kodilla.checkers.game;

public class Figure {
    public final static String BLACK = "B";
    public final static String WHITE = "W";
    public final static String NONE = "N";
    protected String color;
    public Figure(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
