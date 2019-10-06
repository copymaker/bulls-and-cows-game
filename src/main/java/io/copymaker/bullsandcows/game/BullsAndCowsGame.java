package io.copymaker.bullsandcows.game;

import io.copymaker.bullsandcows.game.digit.DigitSet;
import io.copymaker.bullsandcows.game.score.ScoreCalculator;
import io.copymaker.bullsandcows.game.score.Scores;

public class BullsAndCowsGame {

    private final DigitSet questionSet;

    private final ScoreCalculator calculator = new ScoreCalculator();

    BullsAndCowsGame(DigitSet digitSet) {
        this.questionSet = digitSet;
        checkDigitSetSize(this.questionSet);
    }

    public Scores calculateScores(DigitSet answerSet) {
        checkDigitSetSize(answerSet);
        return calculator.calculate(questionSet, answerSet);
    }

    public int getLevel() {
        return questionSet.size();
    }

    private void checkDigitSetSize(DigitSet digitSet) {
        int level = getLevel();
        if (digitSet.size() != level) {
            throw new IllegalArgumentException(String.format("숫자의 자릿수가 일치하지 않습니다. (actual: %d, expect: %d)", digitSet.size(), level));
        }
    }

}
