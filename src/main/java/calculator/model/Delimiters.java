package calculator.model;

public class Delimiters {
    private final String BASIC_DELIMITER_COMMA = ",";
    private final String BASIC_DELIMITER_COLON = ":";
    private final String BASIC_DELIMITER_REGEX = "[" + BASIC_DELIMITER_COMMA + BASIC_DELIMITER_COLON + "]";
    private String CUSTOM_DELIMITER;

    public String getBASIC_DELIMITER() {
        return BASIC_DELIMITER_COMMA;
    }

    public String getBASIC_DELIMITER_REGEX() {
        return BASIC_DELIMITER_REGEX;
    }

    public void setCustomDelimiter(final String customDelimiter) {
        CUSTOM_DELIMITER = customDelimiter;
    }
}
