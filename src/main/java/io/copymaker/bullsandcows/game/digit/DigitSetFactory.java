package io.copymaker.bullsandcows.game.digit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DigitSetFactory {

    private final List<Integer> baseNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public DigitSet createDigitSet(int number) {
        return new DigitSet(toDigits(toIntegerList(number)));
    }

    public DigitSet createRandomDigitSet(int level) {
        Collections.shuffle(baseNumbers);
        return new DigitSet(toDigits(baseNumbers.subList(0, level)));
    }

    private List<Integer> toIntegerList(int number) {
        return String.valueOf(number)
                .chars()
                .mapToObj(ch -> Character.getNumericValue(ch))
                .collect(Collectors.toList());
    }

    private List<Digit> toDigits(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i -> Digit.of(numbers.get(i), i))
                .collect(Collectors.toList());
    }

}
