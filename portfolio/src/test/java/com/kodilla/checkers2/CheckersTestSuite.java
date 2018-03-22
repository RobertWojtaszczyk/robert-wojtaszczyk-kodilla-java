package com.kodilla.checkers2;

import com.kodilla.checkers2.game.Board;
import com.kodilla.checkers2.game.Definitions.Type;
import com.kodilla.checkers2.game.Figure;
import org.junit.Assert;
import org.junit.Test;

public class CheckersTestSuite {
    @Test
    public void testProperMoveFigure() {
        //Given
        Board board = new Board();
        board.initializeBoard();
        System.out.println(board);
        //When
        Figure figure = board.getFigure(2,3);
        boolean result = board.moveFigure(2,3,3,4);
        //Then
        System.out.println(board);
        Assert.assertTrue(result);
        Assert.assertEquals(figure, board.getFigure(3, 4));
        Assert.assertEquals(Type.NONE, board.getFigure(2, 3).getType());
    }

    @Test
    public void testMoveFigureToWhiteField() {
        //Given
        Board board = new Board();
        board.initializeBoard();
        //When
        Figure figure = board.getFigure(2,3);
        boolean result = board.moveFigure(2,3,3,3);
        //Then
        Assert.assertFalse(result);
        Assert.assertEquals(figure, board.getFigure(2, 3));
        Assert.assertEquals(Type.ILLEGAL, board.getFigure(3, 3).getType());
    }
}
