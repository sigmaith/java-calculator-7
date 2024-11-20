package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.model.Converter;
import calculator.model.PositiveNumbers;

public class InputView {
    private static final String INPUT_GUIDE = "덧셈할 문자열을 입력해 주세요.";

    public static PositiveNumbers askExpression(Converter converter) {
        System.out.println(INPUT_GUIDE);
        return converter.convert(readLine());
    }
}
