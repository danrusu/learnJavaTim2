package main.advanced.generics;

import main.advanced.streams.Cars;
import org.junit.jupiter.api.Test;

public class BoxTest {

    @Test
    public void test_box(){

        Box myBox = new Box("string box", 100);

        Box yourBox = new Box(
                new Cars.Car(Cars.CarProducer.AUDI, "A4", 35000),
                200);

        System.out.println("myBox:");
        Object myString = myBox.getItem();
        System.out.println(myString);
        Object myInt = myBox.getItem2();
        System.out.println(myInt);


        System.out.println("\nyourBox:");
        Object yourCar = yourBox.getItem();
        Object yourInt = yourBox.getItem2();
        System.out.println(yourCar);
        System.out.println(yourInt);

        System.out.println(
                ((Cars.Car)yourCar).getModelName());

        // wrong cast - no error from compiler; throws exception ClassCastException at runtime
        System.out.println((Cars.Car)yourInt);

    }
}
