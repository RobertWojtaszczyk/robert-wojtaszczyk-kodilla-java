package com.kodilla.checkers.game;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Row> rows = new ArrayList<Row>();
    //generate empty board
    public List generateBoard() {
        for (int i = 0; i < 8; i++) {
            Row row = new Row();
            row.generateRow();
            rows.add(row);
        }
        return rows;
    }
    public Figure getFigure(int row, int col) {
        return rows.get(row).getColumns().get(col);
    }
    public void setFigure(int row, int col, Figure figure) {
        rows.get(row).getColumns().add(col,figure);
        rows.get(row).getColumns().remove(col + 1);
    }
    @Override
    public String toString() {
        String boardString = "  -------------------------\n";
        int rowNumber = 1;
        for (Row row : rows) {
            boardString += rowNumber + "." + row + "\n";
            boardString += "  -------------------------\n";
            rowNumber++;
        }
        return boardString;
    }
    public boolean moveFigure(int currentX, int currentY, int targetX, int targetY){
        if (getFigure(currentX, currentY) instanceof None){
            System.out.println("No figure at current position, can not execute!");
            return false;
        }
        if (targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7){
            System.out.println("Out of board, can not execute!");
            return false;
        }
        if (getFigure(targetX, targetY) instanceof None) {
            setFigure(targetX, targetY, getFigure(currentX, currentY));
            setFigure(currentX, currentY, new None());
            return true;
        } else {
            System.out.println("There is already a figure in target place, can not execute!");
            return false;
        }
    }
    public void newGame() {
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (((i % 2) != 0) && (j == 0 || j == 2)) {
                    setFigure(j, i, new Pawn(Figure.WHITE));
                }
                if (((i % 2) == 0) && (j == 1)) {
                    setFigure(j, i, new Pawn(Figure.WHITE));
                }
                if (((i % 2) != 0) && (j == 6)) {
                    setFigure(j, i, new Pawn(Figure.BLACK));
                }
                if (((i % 2) == 0) && (j == 5 || j == 7)) {
                    setFigure(j, i, new Pawn(Figure.BLACK));
                }
            }
        }
    }
}
