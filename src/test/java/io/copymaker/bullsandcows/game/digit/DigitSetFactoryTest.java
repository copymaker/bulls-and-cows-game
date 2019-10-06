package io.copymaker.bullsandcows.game.digit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.*;

class DigitSetFactoryTest {

    private DigitSetFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new DigitSetFactory();
    }

    @Test
    @DisplayName("숫자를 받아 DigitSet 을 리턴한다.")
    void test() {
        DigitSet digitSet = new DigitSet(Arrays.asList(
                Digit.of(1, 0),
                Digit.of(2, 1),
                Digit.of(3, 2)));

        assertThat(factory.createDigitSet(123)).isEqualTo(digitSet);
    }

}