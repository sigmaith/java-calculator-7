package calculator.service;

import static calculator.view.InputView.askInput;
import static calculator.view.OutputView.printResult;

import calculator.model.Calculator;

public class CalculatorService {
    private final Calculator calculator;

    public CalculatorService() {
        calculator = new Calculator(askInput());
    }

    public void operate() {
        printResult(calculator.getResult());
    }
}
