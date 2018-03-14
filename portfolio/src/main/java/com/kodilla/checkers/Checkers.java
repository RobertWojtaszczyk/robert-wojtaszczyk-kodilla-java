package com.kodilla.checkers;

import com.kodilla.checkers.game.Board;

public class Checkers {
    public static void main(String[] args) {
        Board board = new Board();
        board.generateBoard();
        board.newGame();
        System.out.println(board);
        //System.out.println(board.getFigure(0,7));
        /*if (board.getFigure(0,6) instanceof None) {
            Figure f = board.getFigure(0,6);
            System.out.println(f.getColor());
            System.out.println("Puste pole");
        }*/
        if (board.moveFigure(2,3,3,4)){
            System.out.println(board);
        }
    }
}
