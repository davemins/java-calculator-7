package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.DelimiterExtractor;
import calculator.domain.NumberParser;
import calculator.view.View;

public class CalculatorController {
    private final DelimiterExtractor delimiterExtractor;
    private final NumberParser numberParser;
    private final Calculator calculator;


    public CalculatorController() {
        this.delimiterExtractor = new DelimiterExtractor();
        this.numberParser = new NumberParser();
        this.calculator = new Calculator();
    }

    public void run() {
        String input = View.requestString();

        String delimiters = delimiterExtractor.extract(input);
        String[] numbers = numberParser.parse(input, delimiters);

        int result = calculator.sum(numbers);

    }
}
