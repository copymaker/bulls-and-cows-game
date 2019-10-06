package io.copymaker.bullsandcows.game.digit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DigitTest {

    @Test
    @DisplayName("1 ~ 9 이외의 값은 예외")
    void shouldThrowWhenOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            Digit digit = Digit.of(-1, 0);
        });
    }

    @Test
    @DisplayName("equals 는 값 만 비교")
    void shouldBeTrueWhenEqualValue() {
        Digit aDigit = Digit.of(1, 0);
        Digit bDigit = Digit.of(1, 1);

        assertThat(aDigit).isEqualTo(bDigit);
    }

    @Test
    @DisplayName("deepEqualTo 는 값 과 위치를 비교")
    void shouldBeTrueWhenDeepEqualValueAndPosition() {
        Digit aDigit = Digit.of(1, 0);
        Digit bDigit = Digit.of(1, 1);

        assertThat(aDigit.deepEqualTo(bDigit)).isFalse();

        aDigit = Digit.of(2, 2);
        bDigit = Digit.of(2, 2);
        assertThat(aDigit.deepEqualTo(bDigit)).isTrue();
    }

}