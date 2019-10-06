package io.copymaker.bullsandcows.game;

import io.copymaker.bullsandcows.game.score.Scores;
import io.copymaker.bullsandcows.game.digit.DigitSet;
import io.copymaker.bullsandcows.game.digit.DigitSetFactory;

import java.util.Scanner;

public class GameRunner {

    private static final int MIN_LEVEL = 3;
    private static final int MAX_LEVEL = 9;

    private BullsAndCowsGame game;
    private boolean isFirstGame = true;

    private final DigitSetFactory factory = new DigitSetFactory();

    public void run() {
        while (true) {
            readyNewGame();
            runGame();

            if (!isContinueGame()) {
                stop();
            }
        }
    }

    private void readyNewGame() {
        printMessage("새로운 게임을 시작합니다.");
        game = createNewGame(isFirstGame ? MIN_LEVEL : getInputGameLevel());
        isFirstGame = false;
    }

    private void runGame() {
        boolean isCorrect = false;
        do {
            isCorrect = runInning();
        } while (!isCorrect);

        printMessage(String.format("%d 개의 숫자를 모두 맞히셨습니다. 게임 종료", game.getLevel()));
    }

    private boolean runInning() {
        try {
            DigitSet answerSet = factory.createDigitSet(getInputNumber());
            Scores scores = game.calculateScores(answerSet);
            printMessage(scores.toString());
            return scores.isCorrect();
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
        }
        return false;
    }

    private BullsAndCowsGame createNewGame(int level) {
        DigitSet questionSet = factory.createRandomDigitSet(level);
        return new BullsAndCowsGame(questionSet);
    }

    public int getInputNumber() {
        printMessage("숫자를 입력해주세요: ");
        return new Scanner(System.in).nextInt();
    }

    public int getInputGameLevel() {
        printMessage("게임 레벨을 선택해주세요: ");
        int level = new Scanner(System.in).nextInt();
        if (level >= MIN_LEVEL && level <= MAX_LEVEL) {
            return level;
        } else {
            printErrorMessage(String.format("게임 레벨은 %d ~ %d 사이로 입력해주세요.", MIN_LEVEL, MAX_LEVEL));
            return getInputGameLevel();
        }
    }

    public boolean isContinueGame() {
        printMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int num = new Scanner(System.in).nextInt();

        if (num == 1) {
            return true;
        } else if (num == 2) {
            return false;
        } else {
            printErrorMessage("1, 2 만 입력 가능합니다.");
            return isContinueGame();
        }
    }

    private void stop() {
        printMessage("게임을 종료합니다.");
        System.exit(0);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.err.println(message);
    }

}
