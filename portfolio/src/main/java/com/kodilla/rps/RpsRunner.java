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
            playerKeyboardInput = UserDialogs.waitForContinue();
        }
        System.out.println("Number of rounds: " + game.getRoundCount());
    }
}
