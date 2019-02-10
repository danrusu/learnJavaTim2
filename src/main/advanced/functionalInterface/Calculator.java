package main.advanced.functionalInterface;

@FunctionalInterface
public interface Calculator {

    String MESSAGE = "Calculate interface";

    // only one abstract method

    int calculate(int val1, int val2);

    //SUM (int val1, int val2) -> val1 + val2
    //MULTIPLY (int val1, int val2) -> val1 * val2
    //DIVIDE (int val1, int val2) -> val1 / val2

    static void message(){
        System.out.println(MESSAGE);
    }
}
