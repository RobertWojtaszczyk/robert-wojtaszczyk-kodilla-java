package com.kodilla.checkers2.game;
import com.kodilla.checkers2.game.Definitions.Color;
import com.kodilla.checkers2.game.Definitions.Type;

public class Figure {
    private final Type type;
    private final Color color;

    public Figure(final Type type, final Color color) {
        this.type = type;
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        if (type == Type.NONE) {
            return "  ";
        }
        if (type == Type.ILLEGAL) {
            return "~~";
        }
        String fig = (color == Color.BLACK) ? "b" : "w";
        return (type == Type.PAWN) ? fig + "P" : fig + "Q";
    }
}