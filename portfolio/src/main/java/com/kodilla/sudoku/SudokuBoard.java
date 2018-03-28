package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype {
    private List<SudokuRow> sudokuRows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            sudokuRows.add(new SudokuRow(true));
        }
    }

    public SudokuBoard(SudokuRow sudokuRow) {
            sudokuRows.add(sudokuRow);
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
    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedSudokuBoard = (SudokuBoard) super.clone();
        clonedSudokuBoard.sudokuRows = new ArrayList<>();
        for (SudokuRow theRow : sudokuRows) {
            SudokuRow clonedRow = new SudokuRow(false);
            for (SudokuElement element : theRow.getSudokuElements()) {
                clonedRow.getSudokuElements().add(new SudokuElement(element.getValue(), element.getPossibleValues()));
            }
            clonedSudokuBoard.getSudokuRows().add(clonedRow);
        }
        return clonedSudokuBoard;
    }
}