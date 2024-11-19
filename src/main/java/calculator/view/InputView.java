package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_GUIDE = "덧셈할 문자열을 입력해 주세요.";

    public static String askInput() {
        System.out.println(INPUT_GUIDE);
        return readLine();
    }
}
