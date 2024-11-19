package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.Error.NOT_INTEGER_RANGE;
import static util.Error.UNDEFINED_DELIMITER;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class customApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자가_2글자인_경우_기능_ㅌㅔ스트() {
        assertSimpleTest(() -> {
            run("//++\\n3++1++5");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 지정하지_않은_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("!1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(UNDEFINED_DELIMITER.getDesciption()));
    }

    @Test
    void 정수범위를_벗어난_숫자입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123123123123123123123123"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NOT_INTEGER_RANGE.getDesciption()));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
