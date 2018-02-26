package com.kodilla.rps;
import com.kodilla.rps.game.Game;
import com.kodilla.rps.game.UserDialogs;

public class RpsRunner {
    public static void main(String[] args) {
        String name = UserDialogs.getPlayerName();
        Game game = new Game(name);
        game.initializeGame();
        char playerKeyboardInput = ' ';
        while (playerKeyboardInput != 'x') { // enum -> 'x'
            game.playRound();
            //jak przerwać pętlę -> break?
            playerKeyboardInput = UserDialogs.waitForContinue();
        }
        //za każdym razem wywoływać game.get... czy raz przypisać do zmiennych i potem pracować na zmiennych
        System.out.println("Number of rounds: " + game.getRoundCount());
        System.out.println("Player " + game.getPlayerName() + ": " + game.getPlayerScore());
        System.out.println("Computer wins: " + game.getComputerScore());
        System.out.println("Number of ties: " + (game.getRoundCount() - game.getComputerScore() - game.getPlayerScore()));
        if (game.getComputerScore() == game.getPlayerScore()) {
            System.out.println("There is no winner. It's a TIE!");
        } else {
            String winner = game.getComputerScore() > game.getPlayerScore() ? "COMPUTER" : "PLAYER: " + game.getPlayerName();
            System.out.println("The WINNER is " + winner + "!");
        }
    }
}
