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

}
