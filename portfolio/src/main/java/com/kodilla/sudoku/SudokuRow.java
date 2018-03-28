package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> sudokuElements = new ArrayList<>();

    public SudokuRow(boolean fillWithNewElements) {
        if (fillWithNewElements) {
            for (int i = 0; i < 9; i++) {
                sudokuElements.add(new SudokuElement(true));
            }
        }
    }

    public List<SudokuElement> getSudokuElements() {
        return sudokuElements;
    }
}