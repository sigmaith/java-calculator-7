package calculator.model;

public class Adder {
    private PositiveNumbers positiveNumbers;
    private int result;

    public Adder(final PositiveNumbers positiveNumbers) {
        result = positiveNumbers.getSumOfPositiveNumbers();
    }

    public int getResult() {
        return result;
    }
}
