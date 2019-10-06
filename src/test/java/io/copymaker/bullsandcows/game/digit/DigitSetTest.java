package io.copymaker.bullsandcows.game.digit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DigitSetTest {

    private DigitSet digitSet;

    private final Digit DIGIT_1_1 = Digit.of(1, 0);
    private final Digit DIGIT_2_2 = Digit.of(2, 1);
    private final Digit DIGIT_3_3 = Digit.of(3, 2);

    private final Digit DIGIT_1_4 = Digit.of(1, 4);
    private final Digit DIGIT_2_5 = Digit.of(2, 5);
    private final Digit DIGIT_3_6 = Digit.of(3, 6);

    @Test
    @DisplayName("중복 된 숫자 값은 예외")
    void shouldThrowWhenDuplicateValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            digitSet = new DigitSet(Arrays.asList(
                    Digit.of(1, 0),
                    Digit.of(1, 1),
                    Digit.of(2, 2)));
        });
    }

    @Test
    @DisplayName("size() 테스트")
    void shouldBeCorrectSize() {
        digitSet = new DigitSet(Arrays.asList(
                Digit.of(1, 0),
                Digit.of(2, 1),
                Digit.of(3, 2)));

        assertThat(digitSet.size()).isEqualTo(3);

        digitSet = new DigitSet(Arrays.asList(
                Digit.of(1, 0),
                Digit.of(2, 1),
                Digit.of(3, 2),
                Digit.of(4, 3)));

        assertThat(digitSet.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("get() 테스트")
    void shouldReturnDigitWhenGet() {
        digitSet = new DigitSet(Arrays.asList(DIGIT_1_1, DIGIT_2_2, DIGIT_3_3));
        assertThat(digitSet.get(0)).isEqualTo(DIGIT_1_1);
        assertThat(digitSet.get(1)).isEqualTo(DIGIT_2_2);
        assertThat(digitSet.get(2)).isEqualTo(DIGIT_3_3);
    }

    @Test
    @DisplayName("indexOf() 테스트")
    void shouldReturnIndexWhenIndexOf() {
        digitSet = new DigitSet(Arrays.asList(DIGIT_1_1, DIGIT_2_2, DIGIT_3_3));
        assertThat(digitSet.get(0)).isEqualTo(DIGIT_1_1);
        assertThat(digitSet.get(1)).isEqualTo(DIGIT_2_2);
        assertThat(digitSet.get(2)).isEqualTo(DIGIT_3_3);
    }

    @Test
    @DisplayName("deepIndexOf() 테스트")
    void shouldReturnIndexWhenDeepIndexOf() {
        digitSet = new DigitSet(Arrays.asList(DIGIT_1_1, DIGIT_2_2, DIGIT_3_3));

        assertThat(digitSet.deepIndexOf(DIGIT_1_1)).isEqualTo(0);
        assertThat(digitSet.deepIndexOf(DIGIT_1_4)).isEqualTo(-1);

        assertThat(digitSet.deepIndexOf(DIGIT_2_2)).isEqualTo(1);
        assertThat(digitSet.deepIndexOf(DIGIT_2_5)).isEqualTo(-1);

        assertThat(digitSet.deepIndexOf(DIGIT_3_3)).isEqualTo(2);
        assertThat(digitSet.deepIndexOf(DIGIT_3_6)).isEqualTo(-1);
    }

}