package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.Error.NOT_INTEGER_RANGE;
import static util.Error.UNDEFINED_DELIMITER;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void 기능_테스트() {
        Calculator calculator = new Calculator("1,2,3");
        assertThat(calculator.getResult()).isEqualTo(6);
    }

    @Test
    void 지정되지_않은_구분자_예외_테스트() {
        Calculator calculator = new Calculator("+1,2,3");
        assertThatThrownBy(() -> calculator.getResult()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UNDEFINED_DELIMITER.getDesciption());
    }

    @Test
    void 정수_범위를_벗어난_경우_예외_테스트() {
        Calculator calculator = new Calculator("123123123123123123123123");
        assertThatThrownBy(() -> calculator.getResult()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_INTEGER_RANGE.getDesciption());
    }
}