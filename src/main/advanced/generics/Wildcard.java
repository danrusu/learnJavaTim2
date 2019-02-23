package main.advanced.generics;


import main.advanced.inheritance.Car;
import main.advanced.inheritance.Vehicle;

public class Wildcard {


    //private static <T, U> void printItemInside(
      //      BoxGeneric<T, U> genericBox)

    private static void printItemInside(
            BoxGeneric<? extends Vehicle, ?> genericBox) {

        System.out.println(genericBox.getItem());
        System.out.println(genericBox.getItem2());
    }


    public static void main(String[] args) {

        BoxGeneric<Car, String> myBox = new BoxGeneric<>(
                new Car("Ford", 5, "red", 140),
                "second string");

        printItemInside(myBox);
    }
}
