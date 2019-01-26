package main.advanced.encapsulation;

import main.advanced.inheritance.Car;

import java.util.ArrayList;
import java.util.List;

public class CarShop {

    private List<Car> cars;

    public CarShop(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();

        final Car audi = new Car("Audi", 5, "red", 260);
        final Car porsche = new Car("Porsche", 2, "orange", 300);
        final Car ford = new Car("Ford", 5, "green", 160);

        carList.add(audi);
        carList.add(porsche);

        //CarShop carShop = new CarShop(List.copyOf(carList));
        CarShop carShop = new CarShop(carList);

        System.out.println(carShop.getCars());

        // encapsulation does not mean immutability !!!
        carList.add(ford);
        System.out.println(carShop.getCars());
    }
}
