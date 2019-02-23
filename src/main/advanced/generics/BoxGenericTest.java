package main.advanced.generics;

import main.advanced.streams.Cars;
import org.junit.jupiter.api.Test;

public class BoxGenericTest {

    @Test
    public void test_generic_box(){

        BoxGeneric<String, Integer> myBox = new BoxGeneric<>(
                "string box",
                100);

        BoxGeneric<Cars.Car, Integer> yourBox = new BoxGeneric<>(
                new Cars.Car(Cars.CarProducer.AUDI, "A4", 35000),
                35000);


        System.out.println("myBox:");
        String myString = myBox.getItem();
        System.out.println(myString);
        Integer myInt = myBox.getItem2();
        System.out.println(myInt);


        System.out.println("\nyourBox:");
        Cars.Car yourCar = yourBox.getItem();
        Integer yourInt = yourBox.getItem2();
        System.out.println(yourCar);
        System.out.println(yourInt);


        System.out.println(yourCar.getModelName());

    }
}
