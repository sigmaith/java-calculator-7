package calculator.model;

import java.util.Arrays;
import java.util.List;

public class PositiveNumbers {
    private List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(String[] rawNumbers) {
        positiveNumbers = Arrays.stream(rawNumbers).map(rawNumber -> new PositiveNumber(rawNumber)).toList();
    }

    public int getSumOfPositiveNumbers() {
        return positiveNumbers.stream().mapToInt(p -> p.getNumber()).sum();
    }
}
