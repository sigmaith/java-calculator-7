package calculator.controller;

import static calculator.view.InputView.askInput;
import static calculator.view.OutputView.printResult;

import calculator.model.Calculator;

public class Controller {
    private final Calculator calculator;

    public Controller() {
        calculator = new Calculator(askInput());
    }

    public void operate() {
        printResult(calculator.getResult());
    }
}
