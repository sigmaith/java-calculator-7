package calculator;

import calculator.service.CalculatorService;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        calculatorService.operate();
    }
}
