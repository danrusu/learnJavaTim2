package main.advanced.encapsulation;

import main.advanced.inheritance.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.List.copyOf;

public class CarShop {

    private List<Car> cars;

    public CarShop(List<Car> cars) {
        this.cars = cars;
    }

    public void printCars() {
        System.out.println(cars);
    }


    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();

        Car audi = new Car("Audi", 5, "red", 260);
        Car porsche = new Car("Porsche", 2, "black", 260);
        Car ford = new Car("Ford", 5, "red", 260);
      /*  carList.add(audi);
        carList.add(porsche);*/


        carList = Arrays.asList(
                new Car("Audi", 5, "red", 260),
                new Car("Porsche", 2, "black", 260)
        );


        CarShop carShop = new CarShop(copyOf(carList));

        carShop.printCars();

        carList.add(ford);
        porsche.color = "white";

        carShop.printCars();

    }

    public static void main1(String[] args) {

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(4);
        ints.add(8);
/*

        for (int i = 0; i < ints.size(); i++) {
            System.out.println(ints.get(i));
        }

        for(int i : ints){
            System.out.println(i);
        }

*/

        System.out.println(ints);

    }
}
