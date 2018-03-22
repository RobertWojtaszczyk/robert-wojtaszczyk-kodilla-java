package com.kodilla.checkers2.game;

import com.kodilla.checkers2.game.Definitions.Color;
import com.kodilla.checkers2.game.Definitions.Type;
import java.util.ArrayList;

public class Board {
    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 9;
    private ArrayList<Row> rows = new ArrayList<>();

    public Board() {
        for (int i = 0; i <= Board.MAX_INDEX; i++) {
            rows.add(new Row());
        }
    }

    public void initializeBoard() {
        for (int y = MIN_INDEX; y <= MAX_INDEX; y++) {
            for (int x = MIN_INDEX; x <= MAX_INDEX; x++) {
                if (((x % 2) != 0) && (y == MIN_INDEX || y == MIN_INDEX + 2)) {
                    setFigure(new Figure(Type.PAWN, Color.BLACK), x, y);
                }
                else if (((x % 2) == 0) && (y == MIN_INDEX + 1 || y == MIN_INDEX + 3)) {
                    setFigure(new Figure(Type.PAWN, Color.BLACK), x, y);
                }
                else if (((x % 2) != 0) && (y == MAX_INDEX - 3 || y == MAX_INDEX - 1)) {
                    setFigure(new Figure(Type.PAWN, Color.WHITE), x, y);
                }
                else if (((x % 2) == 0) && (y == MAX_INDEX - 2 || y == MAX_INDEX)) {
                    setFigure(new Figure(Type.PAWN, Color.WHITE), x, y);
                }
                else if ((((x % 2) == 0) && ((y % 2) == 0)) || (((x % 2) != 0) && ((y % 2) != 0))) {
                    setFigure(new Figure(Type.ILLEGAL, Color.NONE), x, y);
                } /*else {
                    setFigure(new Figure(Type.NONE, Color.NONE), x, y);
                }*/
            }
        }
    }

    public Figure getFigure(int x, int y) {
        return rows.get(y).getColumn().get(x);
    }

    private void setFigure(Figure figure, int x, int y) {
        rows.get(y).getColumn().set(x, figure);
    }

    public boolean moveFigure(int currentX, int currentY, int targetX, int targetY){
        if (Validator.validate(this, currentX, currentY, targetX, targetY)) {
            setFigure(getFigure(currentX, currentY), targetX, targetY);
            setFigure(new Figure(Type.NONE, Color.NONE), currentX, currentY);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int y = MIN_INDEX; y <= MAX_INDEX; y++) {
            result += "|";
            for (int x = MIN_INDEX; x <= MAX_INDEX; x++) {
                result += rows.get(y).getColumn().get(x) + "|";
            }
            result += "\n";
        }
        return result;
    }
}