package io.copymaker.bullsandcows.game.score;

public enum Score {
    STRIKE("스트라이크"),
    BALL("볼"),
    OUT("아웃");

    private final String name;

    Score(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
