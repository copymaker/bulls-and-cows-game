package io.copymaker.bullsandcows.game.digit;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class DigitSet {

    private final List<Digit> digits;

    DigitSet(List<Digit> digits) {
        this.digits = digits;
        checkDuplicate();
    }

    public int size() {
        return digits.size();
    }

    public Digit get(int index) {
        return digits.get(index);
    }

    public int indexOf(Digit digit) {
        return digits.indexOf(digit);
    }

    public int deepIndexOf(Digit digit) {
        if (digit == null) {
            for (int i = 0; i < digits.size(); i++) {
                if (digits.get(i) == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < digits.size(); i++) {
                if (digit.deepEqualTo(digits.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void checkDuplicate() {
        Set<Digit> set = new HashSet<>(digits);
        if (set.size() != digits.size()) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다. (actual: " + digits.toString() + ")");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitSet digitSet = (DigitSet) o;
        return Objects.equals(digits, digitSet.digits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digits);
    }

    @Override
    public String toString() {
        return digits.toString();
    }
}
