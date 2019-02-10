package main.advanced.primitivesAndWrappers;

public class NumbersTest {

    public static void main(String[] args) {

        int intPrimitive = 3;
        Integer intObject = 3; // auto boxing

        intPrimitive = intObject.intValue(); // auto unboxing

        intObject = intPrimitive; // auto boxing

        intObject = Integer.valueOf(intPrimitive); // explicit boxing
        intObject = Integer.valueOf("3");

        double d = intObject.doubleValue();
        System.out.println(d);
    }
}
