package io.copymaker.bullsandcows.game.score;

import io.copymaker.bullsandcows.game.digit.Digit;
import io.copymaker.bullsandcows.game.digit.DigitSet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScoreCalculator {

    public Scores calculate(DigitSet questionSet, DigitSet answerSet) {
        return new Scores(getScoreList(questionSet, answerSet));
    }

    private List<Score> getScoreList(DigitSet questionSet, DigitSet answerSet) {
        return IntStream.range(0, answerSet.size())
                .mapToObj(i -> findScore(questionSet, answerSet.get(i)))
                .collect(Collectors.toList());
    }

    private Score findScore(DigitSet questionSet, Digit digit) {
        if (isSameValueAndPosition(questionSet, digit)) {
            return Score.STRIKE;
        }

        if (isSameValue(questionSet, digit)) {
            return Score.BALL;
        }

        return Score.OUT;
    }

    private boolean isSameValueAndPosition(DigitSet questionSet, Digit digit) {
        return questionSet.deepIndexOf(digit) > - 1;
    }

    private boolean isSameValue(DigitSet questionSet, Digit digit) {
        return questionSet.indexOf(digit) > -1;
    }
}
