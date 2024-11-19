package calculator.model;

public class Calculator {
    private final String CUSTOM_DELIMITER_HEADER = "//";
    private final String CUSTOM_DELIMITER_FOOTER = "\\n";
    private final String BASIC_DELIMITER_COMMA = ",";
    private final String BASIC_DELIMITER_COLON = ":";
    private final String BASIC_DELIMITER_REGEX = "[" + BASIC_DELIMITER_COMMA + BASIC_DELIMITER_COLON + "]";
    private int result = 0;

    public Calculator(final String text) {
        result = sum(text);
    }

    private int sum(final String text) {
        if (text.startsWith(CUSTOM_DELIMITER_HEADER) && text.contains(CUSTOM_DELIMITER_FOOTER)) {
            String delimiterCustom = separateCustomDelimiter(text);
            return sum(text.substring(getFooterIndex(text) + 2).replace(delimiterCustom, BASIC_DELIMITER_COMMA));
        }
        int total = 0;
        for (final String rawNumber : text.split(BASIC_DELIMITER_REGEX)) {
            int number = validateNumber(rawNumber);
            total += number;
        }
        return total;
    }

    private String separateCustomDelimiter(final String text) {
        int indexOfFooter = getFooterIndex(text);
        return text.substring(indexOfFooter - 2, indexOfFooter);
    }

    private int getFooterIndex(final String text) {
        return text.indexOf(CUSTOM_DELIMITER_FOOTER);
    }

    private int validateNumber(final String rawNumber) {
        try {
            final int number = Integer.parseInt(rawNumber);
            validatePositive(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getResult() {
        return result;
    }
}
