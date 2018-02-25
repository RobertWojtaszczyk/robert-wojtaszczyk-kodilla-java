package com.kodilla.checkers.game;

public class Queen extends Figure {
    public Queen(String color) {
        super(color);
    }
    @Override
    public String toString() {
        if (color.equals(BLACK)) {
            return "bQ";
        } else {
            return "wQ";
        }
    }
}
