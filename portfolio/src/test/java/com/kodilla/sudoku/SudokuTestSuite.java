package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SudokuTestSuite {
    @Test
    public void testSudokuCloneBoard() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(0).setValue(1);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).getPossibleValues().clear();
        List<Integer> newPossibleValues = new ArrayList<>();
        newPossibleValues.add(2);
        newPossibleValues.add(3);
        newPossibleValues.add(4);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).setPossibleValues(newPossibleValues);
        //When
        SudokuBoard clonedSudokuBoard = null;
        try {
            clonedSudokuBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            // do nothing
        }
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(0).setValue(9);
        //Then
        Assert.assertEquals(1,clonedSudokuBoard.getSudokuRows().get(0).getSudokuElements().get(0).getValue());
        Assert.assertEquals(3,clonedSudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).getPossibleValues().size());
    }

    @Test
    public void testSudokuCheck2Condition() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(0).setValue(1);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).setValue(2);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(2).setValue(3);
        //When
        Algorithm algorithm = new Algorithm(sudokuBoard);
        algorithm.resolveSudoku();
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().remove(new Integer(9));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(4).getPossibleValues().remove(new Integer(9));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(5).getPossibleValues().remove(new Integer(9));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(6).getPossibleValues().remove(new Integer(9));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(7).getPossibleValues().remove(new Integer(9));
        algorithm.resolveSudoku();
        //Then
        Assert.assertEquals(4, sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getValue());
    }

    @Test
    public void testSudokuAlgorithmGeoCaching() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).setValue(2);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(8).setValue(3);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(1).setValue(7);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(4).setValue(9);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(6).setValue(2);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(1).setValue(6);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(2).setValue(1);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(3).setValue(5);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(4).setValue(8);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(7).setValue(4);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(8).setValue(9);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(0).setValue(8);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(5).setValue(4);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(8).setValue(1);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(0).setValue(7);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(3).setValue(8);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(8).setValue(4);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(0).setValue(5);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(1).setValue(9);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(4).setValue(7);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(5).setValue(8);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(6).setValue(3);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(7).setValue(1);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(2).setValue(4);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(4).setValue(3);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(7).setValue(5);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(0).setValue(6);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(5).setValue(1);
        System.out.println("Simple sudoku test1:");
        System.out.println(sudokuBoard);
        //When
        Algorithm algorithm = new Algorithm(sudokuBoard);
        boolean continueAlg = true;
        while (continueAlg) {
            continueAlg = algorithm.resolveSudoku();
        }
        //Then
    }

    @Test
    public void testSudokuAlgorithmSimplePuzzle() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).setValue(2);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(5).setValue(4);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(6).setValue(8);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(7).setValue(1);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(1).setValue(4);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(5).setValue(8);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(6).setValue(2);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(7).setValue(6);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(8).setValue(3);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(0).setValue(3);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(3).setValue(1);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(4).setValue(6);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(8).setValue(4);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(0).setValue(1);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(4).setValue(4);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(6).setValue(5);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(7).setValue(8);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(0).setValue(6);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(1).setValue(3);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(2).setValue(5);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(3).setValue(8);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(4).setValue(2);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(8).setValue(7);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(0).setValue(2);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(3).setValue(5);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(4).setValue(9);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(6).setValue(1);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(0).setValue(9);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(1).setValue(1);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(3).setValue(7);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(7).setValue(4);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(3).setValue(6);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(4).setValue(8);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(6).setValue(7);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(8).setValue(1);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(0).setValue(8);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(3).setValue(4);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(5).setValue(3);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(7).setValue(5);
        System.out.println("Simple sudoku test2:");
        System.out.println(sudokuBoard);
        //When
        Algorithm algorithm = new Algorithm(sudokuBoard);
        boolean continueAlg = true;
        while (continueAlg) {
            continueAlg = algorithm.resolveSudoku();
            //continueAlg = false;
        }
        //Then
    }

    @Test
    public void testSudokuAlgorithmMephamDpuzzle() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).setValue(9);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).setValue(7);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(6).setValue(8);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(7).setValue(6);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(1).setValue(3);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(2).setValue(1);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(5).setValue(5);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(7).setValue(2);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(0).setValue(8);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(2).setValue(6);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(2).setValue(7);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(4).setValue(5);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(8).setValue(6);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(3).setValue(3);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(5).setValue(7);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(0).setValue(5);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(4).setValue(1);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(6).setValue(7);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(6).setValue(1);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(8).setValue(9);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(1).setValue(2);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(3).setValue(6);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(6).setValue(3);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(7).setValue(5);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(1).setValue(5);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(2).setValue(4);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(5).setValue(8);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(7).setValue(7);
        System.out.println("Test for The Mepham diabolical Sudoku puzzle:");
        System.out.println(sudokuBoard);
        //When
        Algorithm algorithm = new Algorithm(sudokuBoard);
        boolean continueAlg = true;
        while (continueAlg) {
            continueAlg = algorithm.resolveSudoku();
        }
        //Then
    }

    @Test
    public void testSudokuAlgorithmWillShortzPuzzle301() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).setValue(3);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(2).setValue(9);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).setValue(5);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(3).setValue(8);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(7).setValue(7);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(4).setValue(1);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(6).setValue(9);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(8).setValue(4);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(0).setValue(1);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(3).setValue(4);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(8).setValue(3);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(2).setValue(7);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(6).setValue(8);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(7).setValue(6);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(2).setValue(6);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(3).setValue(7);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(5).setValue(8);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(6).setValue(2);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(1).setValue(1);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(4).setValue(9);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(8).setValue(5);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(5).setValue(1);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(8).setValue(8);
        System.out.println("Test for Will Shortz's puzzle 301:");
        System.out.println(sudokuBoard);
        //When
        Algorithm algorithm = new Algorithm(sudokuBoard);
        boolean continueAlg = true;
        while (continueAlg) {
            continueAlg = algorithm.resolveSudoku();
        }
        //Then
    }

    @Test
    public void testSudokuAlgorithmAnotherToughPuzzle() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(0).setValue(8);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(4).setValue(2);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(8).setValue(5);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(5).setValue(6);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(6).setValue(2);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(7).setValue(4);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(1).setValue(3);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(2).setValue(8);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(5).setValue(7);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(6).setValue(1);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(0).setValue(2);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(2).setValue(4);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(6).setValue(3);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(8).setValue(9);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(2).setValue(7);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(3).setValue(4);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(6).setValue(5);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(7).setValue(2);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(2).setValue(6);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(1).setValue(7);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(2).setValue(2);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(3).setValue(5);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(0).setValue(6);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(4).setValue(8);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(8).setValue(1);
        System.out.println("Test for tough puzzle:");
        System.out.println(sudokuBoard);
        //When
        Algorithm algorithm = new Algorithm(sudokuBoard);
        boolean continueAlg = true;
        while (continueAlg) {
            continueAlg = algorithm.resolveSudoku();
        }
        //Then
    }
}