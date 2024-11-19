package calculator.view;

public class OutputView {
    private static final String RESULT_GUIDE = "결과 : %d";

    public static void printResult(int result) {
        System.out.println(String.format(RESULT_GUIDE, result));
    }
}
