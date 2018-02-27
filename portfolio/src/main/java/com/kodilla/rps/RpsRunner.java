package com.kodilla.rps;
import com.kodilla.rps.game.Game;
import com.kodilla.rps.game.UserDialogs;
import com.kodilla.rps.game.definitions.CHOICE;

public class RpsRunner {
    public static void main(String[] args) {
        String name = UserDialogs.getPlayerName();
        CHOICE playerAnswer = CHOICE.AGAIN;
        Game game = new Game(name);
        char playerKeyboardInput = ' ';
        while (playerKeyboardInput != 'x' && playerAnswer != CHOICE.END) { // enum -> 'x'
            playerAnswer = game.playRound();
            if (playerAnswer != CHOICE.END && playerAnswer != CHOICE.NEW) {
                playerKeyboardInput = UserDialogs.waitForContinue();
            }
            if (playerAnswer == CHOICE.NEW) {
                UserDialogs.showFinalStats(game);
                game = new Game(name);
            }
        }
        UserDialogs.showFinalStats(game);
    }
}
