package io.copymaker.bullsandcows.game.score;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Scores {

    private final List<Score> scores;

    public Scores(List<Score> scores) {
        this.scores = scores;
    }

    public List<Score> getScores() {
        return new ArrayList<>(scores);
    }

    public boolean isCorrect() {
        if (scores == null || scores.isEmpty()) {
            return false;
        }
        return scores.size() == getCount(score -> score.equals(Score.STRIKE));
    }

    public int getCount(Predicate<Score> predicate) {
        return (int) scores.stream()
                    .filter(predicate)
                    .count();
    }

    public Map<Score, Long> getStatistics() {
        return scores.stream()
                .sorted()
                .collect(Collectors.groupingBy(Function.identity(), () -> new LinkedHashMap<Score, Long>(), Collectors.counting()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Score, Long> entry : getStatistics().entrySet()) {
            sb.append(entry.getValue()).append(" ");
            sb.append(entry.getKey()).append(" ");
        }
        return sb.toString();
    }

}
