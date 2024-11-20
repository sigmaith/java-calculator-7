package calculator.controller;

import static calculator.view.InputView.askExpression;
import static calculator.view.OutputView.printResult;

import calculator.model.Adder;
import calculator.model.Converter;
import calculator.model.PositiveNumbers;

public class Controller {
    private final Converter converter;

    public Controller() {
        converter = new Converter();
    }

    public void operate() {
        PositiveNumbers positiveNumbers = askExpression(new Converter());
        printResult(new Adder(positiveNumbers).getResult());
    }
}
