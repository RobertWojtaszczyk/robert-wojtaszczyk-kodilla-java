package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    private int value = EMPTY;
    private List<Integer> possibleValues = new ArrayList<>();
    public static int EMPTY = -1;

    public SudokuElement(boolean fillPossibleValues) {
        if (fillPossibleValues) {
            for (int i = 1; i < 10; i++) {
                this.possibleValues.add(i);
            }
        }
    }

    public SudokuElement(int value, List<Integer> possibleValues) {
        this.value = value;
        this.possibleValues = possibleValues;
    }

    public boolean setValue(int value) {
        if ((value > 0 && value < 10) || (value == EMPTY)) {
            this.value = value;
            return true;
        } else {
            return false;
        }
    }

    public void setPossibleValues(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    @Override
    public String toString() {
        return (value != EMPTY) ? String.valueOf(value) : " ";
    }
}