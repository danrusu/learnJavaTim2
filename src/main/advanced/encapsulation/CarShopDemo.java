package main.advanced.encapsulation;

import main.advanced.inheritance.Car;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// ENCAPSULATION DOES NOT MEAN IMMUTABILITY!
public class CarShopDemo {

    @Test
    public void encapsulation_test() {
        // encapsulation, no immutability
        List<Car> carList = new ArrayList<>();

        Car audi = new Car("Audi", 5, "red", 260);
        Car porsche = new Car("Porsche", 2, "black", 260);
        Car ford = new Car("Ford", 5, "red", 260);

        carList.add(audi);
        carList.add(porsche);

        CarShop carShop = new CarShop(carList);

        carShop.printCars();

        // change 1
        audi.color = "black";
        audi = null;  // put new object in audi
        carShop.printCars();

        // change 2
        carList.add(ford);
        carShop.printCars();
    }

    @Test
    public void carShop_immutable_test() {

        Car ford = new Car("Ford", 5, "red", 260);

        List<Car> carList = Arrays.asList(
                new Car("Audi", 5, "red", 260),
                new Car("Porsche", 2, "black", 260)
        );

        // List.copyOf returns an unmodifiable list
        List<Car> unmodifiableCarList = List.copyOf(carList);
        CarShop carShop = new CarShop(unmodifiableCarList);

        carShop.printCars();

        // uncomment next line; it will throw UnsupportedOperationException
        //carList.add(ford);

        carList.set(1, ford);  //this works, but does not modify the unmodifiableCarList

        // uncomment next line; it will throw UnsupportedOperationException
        //unmodifiableCarList.set(1, ford);

        carShop.printCars();
    }

    @Test
    public void print_list_test() {

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(4);
        ints.add(8);

        System.out.println("iteration demo 1:");
        for (int i = 0; i < ints.size(); i++) {
            System.out.println(ints.get(i));
        }

        System.out.println("iteration demo 2:");
        for (int i : ints) {
            System.out.println(i);
        }

        System.out.println("List to string:");
        System.out.println(ints);
    }
}
