package io.copymaker.bullsandcows.game;

import io.copymaker.bullsandcows.game.digit.DigitSetFactory;
import io.copymaker.bullsandcows.game.score.Score;
import io.copymaker.bullsandcows.game.digit.DigitSet;
import io.copymaker.bullsandcows.game.score.Scores;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BullsAndCowsGameTest {

    private BullsAndCowsGame game;
    private DigitSetFactory factory;
    private DigitSet answerSet;
    private Scores scores;

    @BeforeEach
    void setUp() {
        factory = new DigitSetFactory();
    }

    @Test
    void gameLevel3ScenarioTest() {
        DigitSet questionSet = factory.createDigitSet(123);
        game = new BullsAndCowsGame(questionSet);

        // 3 아웃
        answerSet = factory.createDigitSet(789);
        scores = game.calculateScores(answerSet);
        assertThat(scores.getScores()).isEqualTo(scores3Out());

        // 1 볼
        answerSet = factory.createDigitSet(389);
        scores = game.calculateScores(answerSet);
        assertThat(scores.getScores()).isEqualTo(scores1Ball());

        // 2 볼
        answerSet = factory.createDigitSet(319);
        scores = game.calculateScores(answerSet);
        assertThat(scores.getScores()).isEqualTo(scores2Ball());

        // 3 볼
        answerSet = factory.createDigitSet(312);
        scores = game.calculateScores(answerSet);
        assertThat(scores.getScores()).isEqualTo(scores3Ball());

        // 1 스트라이크
        answerSet = factory.createDigitSet(189);
        scores = game.calculateScores(answerSet);
        assertThat(scores.getScores()).isEqualTo(scores1Strike());

        // 1 스트라이크 1 볼
        answerSet = factory.createDigitSet(139);
        scores = game.calculateScores(answerSet);
        assertThat(scores.getScores()).isEqualTo(scores1Strike1Ball());

        // 1 스트라이크 2 볼
        answerSet = factory.createDigitSet(132);
        scores = game.calculateScores(answerSet);
        assertThat(scores.getScores()).isEqualTo(scores1Strike2Ball());

        // 2 스트라이크
        answerSet = factory.createDigitSet(129);
        scores = game.calculateScores(answerSet);
        assertThat(scores.getScores()).isEqualTo(scores2Strike());

        // 3 스트라이크
        answerSet = factory.createDigitSet(123);
        scores = game.calculateScores(answerSet);
        assertThat(scores.getScores()).isEqualTo(scores3Strike());
    }

    /**
     *  Fixtures
     */
    private List<Score> scores3Out() {
        return getScoreList(Score.OUT, Score.OUT, Score.OUT);
    }

    private List<Score> scores1Ball() {
        return getScoreList(Score.BALL, Score.OUT, Score.OUT);
    }

    private List<Score> scores2Ball() {
        return getScoreList(Score.BALL, Score.BALL, Score.OUT);
    }

    private List<Score> scores3Ball() {
        return getScoreList(Score.BALL, Score.BALL, Score.BALL);
    }

    private List<Score> scores1Strike() {
        return getScoreList(Score.STRIKE, Score.OUT, Score.OUT);
    }

    private List<Score> scores2Strike() {
        return getScoreList(Score.STRIKE, Score.STRIKE, Score.OUT);
    }

    private List<Score> scores3Strike() {
        return getScoreList(Score.STRIKE, Score.STRIKE, Score.STRIKE);
    }

    private List<Score> scores1Strike1Ball() {
        return getScoreList(Score.STRIKE, Score.BALL, Score.OUT);
    }

    private List<Score> scores1Strike2Ball() {
        return getScoreList(Score.STRIKE, Score.BALL, Score.BALL);
    }

    private List<Score> getScoreList(Score ...score) {
        return Arrays.asList(score);
    }

}