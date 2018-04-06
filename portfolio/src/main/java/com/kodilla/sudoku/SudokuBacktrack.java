package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBacktrack {
    public static List<SudokuBoardDTO> backtrack = new ArrayList<>();

    public static List<SudokuBoardDTO> getBacktrack() {
        return backtrack;
    }
}
