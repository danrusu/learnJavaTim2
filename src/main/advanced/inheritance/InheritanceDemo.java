package main.advanced.inheritance;

import org.junit.jupiter.api.Test;

public class InheritanceDemo {

    @Test
    public void encapsulation_test(){

        Vehicle plane = new Vehicle(
                "plane",
                50,
                "white",
                300);
        //System.out.println(plane.toString());
        System.out.println(plane);
        plane.info();

        Car car = new Car(
                "Audi",
                5,
                "red",
                200);
        System.out.println(car);
        // Object <- Vehicle <- Car
        car.info();
        car.info("sport");

        // public
        car.color = "black";

        // protected
        car.seatCapacity = 4;

        // default (package)
        car.maxSpeed = 300;

        // private + setter
        car.setName("Ford");

        System.out.println(car);

        System.out.println(car.getMessage());
    }

    @Test
    public void polymorphism_test() {

        // Polymorphism
        // Object <- Vehicle <- Car
        Object porsche = new Car(
                "Porsche",
                2 ,
                "orange",
                300);

        ((Vehicle) porsche).info();
        ((Car) porsche).info("sport");
        System.out.println(((Car) porsche).getMessage());
        System.out.println(porsche);

        System.out.println(
                "porsche is Object: " +
                        (porsche instanceof Object));

        System.out.println(
                "porsche is Vehicle: " +
                        (porsche instanceof Vehicle));

        System.out.println(
                "porsche is Car: " +
                        (porsche instanceof Car));
    }

    @Test
    public void interface_test(){
        // Polymorphism
        // Object <- Vehicle <- Car
        Cleanable porsche = new Car(
                "Porsche",
                2 ,
                "orange",
                300);

        Vehicle.printSeparator();

        Drivable.start();

        ((Drivable)porsche).drive(50.5f);
        //((Vehicle)porsche).stop(); wrong
        ((Car)porsche).stop();

        porsche.clean("Premium");

        Car.printSeparator();
    }

}
