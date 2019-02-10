package main.advanced.functionalInterface;

import org.junit.jupiter.api.Test;

import static main.advanced.functionalInterface.Operation.*;

public class CalculateTest {

    public int getResult(int val1, int val2, Operation operation){

        switch (operation){
            case SUM: return val1 + val2;
            case MULTIPLY: return val1 * val2;
            case DIVIDE: return val1 / val2;

            default: throw new Error("Wrong operation");
        }
    }

    public int getResult(int val1, int val2, Calculator calculator){

        return calculator.calculate(val1, val2);
    }

   @Test
   public void calculate_test(){

       System.out.println(getResult(10, 10, SUM));
       System.out.println(getResult(10, 10, MULTIPLY));
       System.out.println(getResult(10, 10, DIVIDE));

       System.out.println("----------------");

       System.out.println(getResult(
               10,
               10,
               sumCalculator
       ));

       System.out.println(getResult(
               10,
               10,
               multiplyCalculator
       ));

       System.out.println(getResult(
               10,
               10,
               divideCalculator
       ));

       System.out.println(getResult(
               10,
               10,
               (val1, val2) -> val1 - val2
       ));

   }

    private Calculator sumCalculator = new Calculator() {
        @Override
        public int calculate(int val1, int val2) {
            return val1 + val2;
        }
    };

    public Calculator multiplyCalculator = (val1, val2) -> val1 * val2;
    private Calculator divideCalculator = (val1, val2) -> val1 / val2;
    private Calculator extractCalculator = (val1, val2) -> val1 - val2;

    public final static Calculator SUM_CALCULATOR = (val1, val2) -> val1 + val2;
    public final static Calculator MULTIPLY_CALCULATOR = (val1, val2) -> val1 * val2;
    public final static Calculator DIVIDE_CALCULATOR = (val1, val2) -> val1 / val2;
}
