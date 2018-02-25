package com.kodilla.checkers.game;

public class Pawn extends Figure {
    public Pawn(String color) {
        super(color);
    }
    @Override
    public String toString() {
        if (color.equals(BLACK)) {
            return "bP";
        } else {
            return "wP";
        }
    }
}
