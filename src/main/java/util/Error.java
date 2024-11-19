package util;

public enum Error {
    NOT_INTEGER_RANGE("정수 범위를 초과합니다."),
    UNDEFINED_DELIMITER("콤마, 세미콜론 외에 지정되지 않은 구분자는 사용할 수 없습니다."),
    NOT_POSITIVE("음수는 허용되지 않습니다."),
    NUMBER_CONTAINED_CUSTOM_DELIMITER("커스텀 구분자에 숫자가 포함될 수 없습니다.");

    private final String desciption;

    Error(final String desciption) {
        this.desciption = desciption;
    }

    public String getDesciption() {
        return desciption;
    }
}
