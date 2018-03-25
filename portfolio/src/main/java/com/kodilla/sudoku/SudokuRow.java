package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> sudokuElements = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < 9; i++) {
            sudokuElements.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getSudokuElements() {
        return sudokuElements;
    }
}