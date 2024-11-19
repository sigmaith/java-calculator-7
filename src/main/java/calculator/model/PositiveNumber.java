package calculator.model;

import static util.Error.NOT_INTEGER_RANGE;
import static util.Error.NOT_POSITIVE;
import static util.Error.UNDEFINED_DELIMITER;

public class PositiveNumber {
    private final String NUMBERFORMAT_REGEX = "^[0-9]+$";
    private int number;

    public PositiveNumber(final String rawNumber) {
        number = validateNumber(rawNumber);
    }

    public int getNumber() {
        return number;
    }

    private int validateNumber(final String rawNumber) {
        try {
            final int number = Integer.parseInt(rawNumber);
            validatePositive(number);
            return number;
        } catch (NumberFormatException e) {
            if (rawNumber.matches(NUMBERFORMAT_REGEX)) {
                throw new IllegalArgumentException(NOT_INTEGER_RANGE.getDesciption());
            }
            throw new IllegalArgumentException(UNDEFINED_DELIMITER.getDesciption());
        }
    }

    private void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE.getDesciption());
        }
    }
}
