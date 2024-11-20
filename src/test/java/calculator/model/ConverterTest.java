package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.Error.NOT_INTEGER_RANGE;
import static util.Error.NUMBER_CONTAINED_CUSTOM_DELIMITER;
import static util.Error.UNDEFINED_DELIMITER;

import org.junit.jupiter.api.Test;

class ConverterTest {
    static Converter converter = new Converter();

    @Test
    void 기능_테스트() {
        assertThat(converter.convert("1,2,3")).isInstanceOf(PositiveNumbers.class);
    }

    @Test
    void 지정되지_않은_구분자_예외_테스트() {
        assertThatThrownBy(() -> converter.convert("1?2,3")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UNDEFINED_DELIMITER.getDesciption());
    }

    @Test
    void 정수_범위를_벗어난_경우_예외_테스트() {
        assertThatThrownBy(() -> converter.convert("123123123123123123123123")).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining(NOT_INTEGER_RANGE.getDesciption());
    }

    @Test
    void 커스텀_구분자에_숫자포함_예외_테스트() {
        assertThatThrownBy(() -> converter.convert("//;112\\n1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_CONTAINED_CUSTOM_DELIMITER.getDesciption());
    }
}