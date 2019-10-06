package io.copymaker.bullsandcows.game.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.*;

class ScoresTest {

    private List<Score> scoreList;
    private Scores scores;

    @Test
    @DisplayName("getScores() 테스트")
    void getScoresTest() {
        scoreList = Arrays.asList(Score.STRIKE, Score.BALL, Score.OUT);
        scores = new Scores(scoreList);
        assertThat(scores.getScores()).isEqualTo(scoreList);
    }

    @Test
    @DisplayName("isCorrect() 테스트")
    void isCorrectTest() {
        scores = new Scores(Arrays.asList(Score.STRIKE, Score.STRIKE, Score.BALL));
        assertThat(scores.isCorrect()).isFalse();

        scores = new Scores(Arrays.asList(Score.STRIKE, Score.STRIKE, Score.STRIKE));
        assertThat(scores.isCorrect()).isTrue();

        scores = new Scores(Arrays.asList(Score.STRIKE, Score.STRIKE, Score.STRIKE, Score.STRIKE));
        assertThat(scores.isCorrect()).isTrue();
    }

    @Test
    @DisplayName("getCount() 테스트")
    void getCountTest() {
        scores = new Scores(Arrays.asList(Score.STRIKE, Score.BALL, Score.OUT));

        assertThat(scores.getCount(s -> s == Score.STRIKE)).isEqualTo(1);
        assertThat(scores.getCount(s -> s == Score.BALL)).isEqualTo(1);
        assertThat(scores.getCount(s -> s == Score.OUT)).isEqualTo(1);
    }

    @Test
    @DisplayName("getStatistics() 테스트")
    void getStatisticsTest() {
        scores = new Scores(Arrays.asList(Score.STRIKE, Score.BALL, Score.OUT));

        Map<Score, Long> map = new HashMap<>();
        map.put(Score.STRIKE, 1L);
        map.put(Score.BALL, 1L);
        map.put(Score.OUT, 1L);

        assertThat(scores.getStatistics()).isEqualTo(map);
    }

    @Test
    @DisplayName("toString() 테스트")
    void toStringTest() {
        scores = new Scores(Arrays.asList(Score.STRIKE, Score.BALL, Score.OUT));
        String result = "1 " + Score.STRIKE.toString() + " 1 " + Score.BALL.toString() + " 1 " + Score.OUT.toString() + " ";

        assertThat(scores.toString()).isEqualTo(result);
    }

}