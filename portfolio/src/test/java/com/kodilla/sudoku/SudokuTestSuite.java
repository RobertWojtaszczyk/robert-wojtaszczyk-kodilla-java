package com.kodilla.sudoku;

import org.junit.Test;

public class SudokuTestSuite {
    @Test
    public void testSudokuCheck2Condition() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(0).setValue(1);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).setValue(2);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(2).setValue(3);
        System.out.println(sudokuBoard);
        //When
        SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(sudokuBoard);
        sudokuAlgorithm.resolveSudoku();
        /*sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(0).getPossibleValues().remove(new Integer(9));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).getPossibleValues().remove(new Integer(9));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(2).getPossibleValues().remove(new Integer(9));*/
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().remove(new Integer(9));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(4).getPossibleValues().remove(new Integer(9));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(5).getPossibleValues().remove(new Integer(9));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(6).getPossibleValues().remove(new Integer(9));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(7).getPossibleValues().remove(new Integer(9));
        sudokuAlgorithm.resolveSudoku();
        System.out.println(sudokuBoard);
        //Then

    }
    @Test
    public void testSudokuCheck2Condition2() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(0).setValue(1);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).setValue(2);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(2).setValue(3);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).setValue(4);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(4).setValue(5);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(6).setValue(6);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(7).setValue(7);
        System.out.println(sudokuBoard);
        //When
        SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(sudokuBoard);
        sudokuAlgorithm.resolveSudoku();
        System.out.println(sudokuBoard);
        sudokuAlgorithm.resolveSudoku();
        System.out.println(sudokuBoard);
        //Then

    }
}
