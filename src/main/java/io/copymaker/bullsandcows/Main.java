package io.copymaker.bullsandcows;

import io.copymaker.bullsandcows.game.BullsAndCowsGame;
import io.copymaker.bullsandcows.game.GameRunner;

public class Main {

    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner();
        gameRunner.run();
    }
}
