package com.kodilla.checkers2.game;

import com.kodilla.checkers2.game.Definitions.Type;
import static com.kodilla.checkers2.game.Board.MAX_INDEX;
import static com.kodilla.checkers2.game.Board.MIN_INDEX;

public class Validator {
    public static boolean validate(Board board, int currentX, int currentY, int targetX, int targetY) {
        if (board.getFigure(currentX, currentY).getType() == Type.NONE){
            System.out.println("No figure at current position, can not execute!");
            return false;
        }
        if (targetX < MIN_INDEX || targetX > MAX_INDEX || targetY < MIN_INDEX || targetY > MAX_INDEX){
            System.out.println("Index out of board size, can not execute!");
            return false;
        }
        if (board.getFigure(targetX, targetY).getType() == Type.ILLEGAL){
            System.out.println("Illegal target field!");
            return false;
        }
        if (board.getFigure(targetX, targetY).getType() != Type.NONE) {
            System.out.println("There is already a figure in target place, can not execute!");
            return false;
        }
        return true;
    }
}
