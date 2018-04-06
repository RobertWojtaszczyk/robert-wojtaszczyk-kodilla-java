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
        System.out.println(sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).getPossibleValues());
        //When
        SudokuBoard clonedSudokuBoard = null;
        try {
            clonedSudokuBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(sudokuBoard);
        System.out.println(clonedSudokuBoard);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(0).setValue(9);
        //Then
        System.out.println(sudokuBoard);
        System.out.println(clonedSudokuBoard);
        System.out.println(clonedSudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).getPossibleValues());
        Assert.assertFalse(sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(0) == clonedSudokuBoard.getSudokuRows().get(0).getSudokuElements().get(0));
        Assert.assertEquals(3,clonedSudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).getPossibleValues().size());
    }

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
        try {
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
        } catch (SudokuAlgorithmException e) {

        }
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
        try {
            sudokuAlgorithm.resolveSudoku();
            System.out.println(sudokuBoard);
            sudokuAlgorithm.resolveSudoku();
            System.out.println(sudokuBoard);
        } catch (SudokuAlgorithmException e) {

        }
        //Then

    }
    @Test
    public void testSudokuAlgorithmThrowException() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(0).setValue(1);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).setValue(2);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(2).setValue(3);
        //When
        SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(sudokuBoard);
        try {
            sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().remove(new Integer(9));
            sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().remove(new Integer(8));
            sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().remove(new Integer(7));
            sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().remove(new Integer(6));
            sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().remove(new Integer(5));
            sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().remove(new Integer(4));
            sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().remove(new Integer(3));
            sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().remove(new Integer(2));
            System.out.println("size: " + sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().size());
            System.out.println("value: " + sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().get(0));
            sudokuAlgorithm.resolveSudoku();
            System.out.println("size: " + sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().size());
            //System.out.println("value: " + sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(3).getPossibleValues().get(0));
        } catch (SudokuAlgorithmException e) {
            System.out.println("Exception!");
        }
        System.out.println(sudokuBoard);
        //Then

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
        System.out.println(sudokuBoard);
        //When
        SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(sudokuBoard);
        int numberOfIterations = 0;
        try {
            boolean continueAlg = true;
            while (continueAlg) {
                continueAlg = sudokuAlgorithm.resolveSudoku();
                numberOfIterations++;
            }

        } catch (SudokuAlgorithmException e) {
            System.out.println("Exception!");
        }
        System.out.println(sudokuBoard);
        System.out.println("Number of iterations: " + numberOfIterations);
        //Then

    }

    @Test
    public void testSudokuAlgorithm2() {
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
        System.out.println(sudokuBoard);
        //When
        SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(sudokuBoard);
        int numberOfIterations = 0;
        try {
            boolean continueAlg = true;
            while (continueAlg) {
                continueAlg = sudokuAlgorithm.resolveSudoku();
                numberOfIterations++;
                //continueAlg = false;
            }

        } catch (SudokuAlgorithmException e) {
            System.out.println("Exception!");
        }
        System.out.println(sudokuBoard);
        System.out.println("Number of iterations: " + numberOfIterations);
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

        System.out.println(sudokuBoard);
        //When
        SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(sudokuBoard);
        int numberOfIterations = 0;
        try {
            boolean continueAlg = true;
            while (continueAlg) {
                continueAlg = sudokuAlgorithm.resolveSudoku();
                numberOfIterations++;
            }

        } catch (SudokuAlgorithmException e) {
            System.out.println("Exception!");
        }
        System.out.println(sudokuBoard);
        System.out.println("Number of iterations: " + numberOfIterations);
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

        System.out.println(sudokuBoard);
        //When
        SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(sudokuBoard);
        int numberOfIterations = 0;
        try {
            boolean continueAlg = true;
            while (continueAlg) {
                continueAlg = sudokuAlgorithm.resolveSudoku();
                numberOfIterations++;
            }

        } catch (SudokuAlgorithmException e) {
            System.out.println("Exception!");
        }
        System.out.println(sudokuBoard);
        System.out.println("Number of iterations: " + numberOfIterations);
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

        System.out.println(sudokuBoard);
        //When
        SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(sudokuBoard);
        int numberOfIterations = 0;
        try {
            boolean continueAlg = true;
            while (continueAlg) {
                continueAlg = sudokuAlgorithm.resolveSudoku();
                numberOfIterations++;
            }

        } catch (SudokuAlgorithmException e) {
            System.out.println("Exception!");
        }
        System.out.println(sudokuBoard);
        System.out.println("Number of iterations: " + numberOfIterations);
        //Then

    }
}