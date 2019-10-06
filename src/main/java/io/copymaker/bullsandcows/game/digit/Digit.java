package io.copymaker.bullsandcows.game.digit;

import java.util.Objects;

public class Digit {

    private final int value;
    private final int position;

    public static Digit of(int value, int position) {
        return new Digit(value, position);
    }

    private Digit(int value, int position) {
        checkProperties(value);
        this.value = value;
        this.position = position;
    }

    private void checkProperties(int value) {
        if (value < 1 || value > 9) {
            throw new IllegalArgumentException("value 는 1 ~ 9 값만 허용 됩니다.");
        }
    }

    public boolean deepEqualTo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit = (Digit) o;
        return value == digit.value &&
                position == digit.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit = (Digit) o;
        return value == digit.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
