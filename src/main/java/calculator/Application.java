package calculator;

import calculator.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller calculatorService = new Controller();
        calculatorService.operate();
    }
}
