package com.kodilla.checkers2.game;
import com.kodilla.checkers2.game.Definitions.Color;
import com.kodilla.checkers2.game.Definitions.Type;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Figure> column = new ArrayList<>();

    public Row() {
        for (int i = 0; i <= Board.MAX_INDEX; i++) {
            column.add(new Figure(Type.NONE, Color.NONE));
        }
    }

    public List<Figure> getColumn() {
        return column;
    }
}