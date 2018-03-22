package com.kodilla.checkers.game;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Figure> columns = new ArrayList<>();
    Figure fig = null;
    //wygenerowanie jednego pustego wiersza
    public List generateRow() {
        for (int i = 0; i < 8; i++) {
            fig = new None();
            columns.add(fig);
        }
        return columns;
    }
    @Override
    public String toString() {
        String rowString = "|";
        for (Figure figure : columns) {
            rowString += figure + "|";
        }
        return rowString;
    }
    public List<Figure> getColumns() {
        return columns;
    }
}
