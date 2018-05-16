package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Backtrack {
    public static List<BoardState> backtrack = new ArrayList<>();

    public static List<BoardState> getBacktrack() {
        return backtrack;
    }
}