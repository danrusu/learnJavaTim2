package main.advanced.streams;

import java.util.List;
import java.util.function.Predicate;

import static main.advanced.streams.Cars.CarProducer.*;

public class Cars {

    public enum CarProducer {
        AUDI,
        PORSCHE,
        FORD,
        HONDA
    }

    public static class Car{
        private CarProducer carProducer;
        private double priceInEuro;
        private String modelName;

        public Car(CarProducer carProducer, String modelName, double priceInEuro) {
            this.carProducer = carProducer;
            this.priceInEuro = priceInEuro;
            this.modelName = modelName;
        }

        public CarProducer getCarProducer() {
            return carProducer;
        }

        public double getPriceInEuro() {
            return priceInEuro;
        }

        public String getModelName() {
            return modelName;
        }

        @Override
        public String toString() {
            return String.join(" | ",
                    carProducer.name(),
                    modelName,
                    priceInEuro + "");
        }

        public static Predicate<Car> isFord = car -> car.getCarProducer().equals(FORD);

        public static Predicate<Car> isHonda = car ->  car.getCarProducer().equals(HONDA);

        public static Predicate<Car> isPorsche = car -> car.getCarProducer().equals(PORSCHE);

        public static Predicate<Car> isAudi = car ->  car.getCarProducer().equals(AUDI);
    }

    private List<Car> cars = List.of(
            new Car(PORSCHE, "Carrera", 90000),
            new Car(PORSCHE, "Cayenne", 80000),
            new Car(PORSCHE, "Panamera", 150000),
            new Car(AUDI, "S8", 120000),
            new Car(AUDI, "Q7", 80000),
            new Car(AUDI, "A4", 35000),
            new Car(AUDI, "A8", 85000),
            new Car(AUDI, "Q5", 40000),
            new Car(FORD, "Fiesta", 11000),
            new Car(FORD, "Focus", 21000),
            new Car(FORD, "Galaxy", 35000),
            new Car(HONDA, "Civic", 23000),
            new Car(HONDA, "CR-V", 29000),
            new Car(HONDA, "HR-V", 23000),
            new Car(HONDA, "Jazz", 14000));

    public List<Car> getCars() {
        return cars;
    }

}
