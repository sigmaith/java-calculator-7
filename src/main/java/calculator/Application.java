package calculator;

import calculator.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller calculatorController = new Controller();
        calculatorController.operate();
    }
}
