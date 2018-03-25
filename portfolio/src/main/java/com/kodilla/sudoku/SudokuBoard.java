package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> sudokuRows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            sudokuRows.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    @Override
    public String toString() {
        String result = "";
        for (int y = 0; y < 9; y++) {
            result += "|";
            for (int x = 0; x < 9; x++) {
                result += sudokuRows.get(y).getSudokuElements().get(x) + "|";
                if (x == 2 || x == 5) result += "|";
            }
            result += "\n";
            if (y == 2 || y ==5) result += "---------------------\n";
        }
        return result;
    }
}