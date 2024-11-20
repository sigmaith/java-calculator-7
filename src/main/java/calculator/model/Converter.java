package calculator.model;

import static util.Error.NUMBER_CONTAINED_CUSTOM_DELIMITER;

public class Converter {
    private final String CUSTOM_DELIMITER_HEADER = "//";
    private final String CUSTOM_DELIMITER_FOOTER = "\\n";
    private final String BASIC_DELIMITER_COMMA = ",";
    private final String BASIC_DELIMITER_COLON = ":";
    private final String BASIC_DELIMITER_REGEX = "[" + BASIC_DELIMITER_COMMA + BASIC_DELIMITER_COLON + "]";
    private final String NUMBER_CONTAINED_STRING_REGEX = ".*[0-9].*";

    private String text;

    public PositiveNumbers convert(final String text) {
        this.text = text;
        String[] textParsed = parse(text);
        return new PositiveNumbers(textParsed);
    }

    private String[] parse(final String text) {
        if (text.startsWith(CUSTOM_DELIMITER_HEADER) && text.contains(CUSTOM_DELIMITER_FOOTER)) {
            String delimiterCustom = separateCustomDelimiter(text);
            String textReplaced = text.substring(getFooterIndex(text) + 2)
                    .replace(delimiterCustom, BASIC_DELIMITER_COMMA);
            return textReplaced.split(BASIC_DELIMITER_REGEX);
        }
        return text.split(BASIC_DELIMITER_REGEX);
    }

    private String separateCustomDelimiter(final String text) {
        int indexOfFooter = getFooterIndex(text);
        String customDelimiter = text.substring(indexOfFooter - 2, indexOfFooter);
        if (customDelimiter.matches(NUMBER_CONTAINED_STRING_REGEX)) {
            throw new IllegalArgumentException(NUMBER_CONTAINED_CUSTOM_DELIMITER.getDesciption());
        }
        return customDelimiter;
    }

    private int getFooterIndex(final String text) {
        return text.indexOf(CUSTOM_DELIMITER_FOOTER);
    }
}
