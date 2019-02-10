package main.advanced.functionalInterface;

import static main.advanced.functionalInterface.CalculateTest.*;

public class CalculatorDemo {

    public static void main(String[] args) {

        System.out.println(new CalculateTest()
                .multiplyCalculator.calculate(2, 2));

        System.out.println(SUM_CALCULATOR.calculate(2,2));
        System.out.println(MULTIPLY_CALCULATOR.calculate(2,2));
        System.out.println(DIVIDE_CALCULATOR.calculate(2,2));
    }
}
