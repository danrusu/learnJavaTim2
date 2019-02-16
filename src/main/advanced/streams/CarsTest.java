package main.advanced.streams;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static main.advanced.streams.Cars.Car;
import static main.advanced.streams.Cars.Car.*;
import static main.advanced.streams.Cars.CarProducer;
import static main.advanced.streams.Cars.CarProducer.AUDI;
import static main.advanced.streams.Cars.CarProducer.PORSCHE;

public class CarsTest {

    List<Car> cars = new Cars().getCars();

    // Using the above list of Car (from main.advanced.streams.Cars)
    // solve the following tasks (TODOs) using the java Stream API
    // (you can also try a classic approach - for loops):

    @Test
    public void get_all_porsche_cars() {

        Predicate<Car> isPorsche = car -> car.getCarProducer().equals(PORSCHE);

        List<Car> porscheCars = cars.stream()
                .filter(isPorsche)
                .collect(toList());

        // print porscheCars list to check if it is correct
        printList(porscheCars);

        // also you can extract the Predicate to a variable with a relevant name
        //Predicate<Car> isPorsche = car -> car.getCarProducer().equals(PORSCHE);
    }

    @Test
    public void get_a_list_of_all_AUDI_cars() {
        List<Car> audiCars = cars.stream()
                .filter(car -> car.getCarProducer().equals(AUDI))
                .collect(toList());

        printList(audiCars);
    }

    @Test
    public void get_a_list_of_all_FORD_and_HONDA_cars() {

        //Predicate<Car> isFordOrHonda = isFord.or(isHonda);

        Predicate<Car> isNotAudiOrPorsche = isPorsche.negate()
                .and(isAudi.negate());

        Predicate<Car> isNotAudiOrPorsche_static = Predicate.not(isPorsche)
                .and(Predicate.not(isAudi));


        List<Car> fordsAndHondas = cars.stream()
                .filter(isFord.or(isHonda))
                .collect(toList());

        printList(fordsAndHondas);
    }

    @Test
    public void get_a_list_of_all_AUDI_models() {
        //TODO
        List<String> audiModels = cars.stream() // stream of Car
                .filter(isAudi) // stream of Car
                .map(car -> car.getModelName())
                //.map(Car::getModelName) // stream of String
                .collect(toList());

        printList(audiModels);
    }

    @Test
    public void get_a_list_of_all_Ford_models_and_prices() {
        //TODO
        // the list must look like: [ "Fiesta:11000.0", "Focus:21000.0", "Galaxy:35000.0" ]
        Function<Car, String> carToModelAndPrice = car ->
                car.getModelName() + ":" + car.getPriceInEuro();

        List<String> fordModelsAndPrices = cars.stream()
                .filter(isFord) // stream of Car
                .map(carToModelAndPrice) // stream of String
                .collect(toList());

        System.out.println(fordModelsAndPrices);
        //printList(fordModelsAndPrices);
    }

    @Test
    public void get_a_collection_of_all_unique_CarProducers() {
        //TODO
        Set<CarProducer> carProducersSet = cars.stream()
                .map(Car::getCarProducer)
                .collect(toSet());

        List<CarProducer> carProducersList = cars.stream()
                .map(Car::getCarProducer)
                .distinct()
                .collect(toList());

        System.out.println("Set:");
        printList(carProducersSet);

        System.out.println("\nList:");
        printList(carProducersList);


    }

    @Test
    public void get_a_string_with_all_unique_CarProducers_separated_by_space() {
        //TODO
        // hint: use Collectors.joining
        Set<String> carProducersSet = cars.stream()
                .map(Car::getCarProducer)
                //.map(carProducer -> carProducer.toString())
                .map(CarProducer::toString)
                .collect(toSet());

        String carProducersString = carProducersSet.stream().collect(Collectors.joining(" "));
        System.out.println(carProducersString);
    }

    @Test
    public void get_a_collection_of_all_unique_CarProducers_that_have_cars_costing_over_100000_euro() {
        //TODO
        Predicate<Car> pricerOver100k = car -> car.getPriceInEuro() > 100000;
        System.out.println(
                cars.stream()
                    .filter(pricerOver100k)
                    .map(Car::getCarProducer)
                    .collect(toSet())
        );
    }

    @Test
    public void get_one_of_the_cheapest_car() {
        //TODO
        Double lowestPrice = cars.stream()
            .map(Car::getPriceInEuro) // stream of Double
            .mapToDouble(Double::doubleValue)
            .min().getAsDouble();

        Car cheapestCar = cars.stream()
                .filter(car -> car.getPriceInEuro() == lowestPrice)
                .findFirst().get();

        System.out.println("Cheapest car: " + cheapestCar);
    }

    @Test
    public void get_cheapest_AUDI_car() {
        //TODO
        Comparator<Car> compareByPrice = comparing(Car::getPriceInEuro);

        Car cheapestAudiCar = cars.stream()
                .filter(isAudi)
                .sorted(compareByPrice)
                .findFirst().get();

        System.out.println(cheapestAudiCar);
    }

    @Test
    public void get_Ford_models_cheaper_than_20000_euro() {
        //TODO
        Predicate<Car> isCheaperThan20k = car -> car.getPriceInEuro() < 20000;

        System.out.println(
                cars.stream()
                    .filter(isFord.and(isCheaperThan20k))
                    .map(Car::getModelName)
                    .collect(toList())
        );
    }

    @Test
    public void get_the_most_expensive_car() {
        //TODO
        Double highestPrice = cars.stream()
                .mapToDouble(Car::getPriceInEuro) // DoubleStream (double primitives stream)
                .max().getAsDouble();

        Car mostExpensiveCar = cars.stream()
                .filter(car -> car.getPriceInEuro() == highestPrice)
                .findFirst().get();

        System.out.println("MostExpensiveCar: " + mostExpensiveCar);
    }

    @Test
    public void get_car_models_more_expensive_than_100000_euro() {
        //TODO
        // the list must look like: [ "PORSCHE Panamera", "AUDI S8" ]
        System.out.println(
                cars.stream()
                    .filter(car -> car.getPriceInEuro() > 100000)
                    .map(car -> car.getCarProducer() + " " + car.getModelName())
                    .collect(toList())
        );

    }

    @Test
    public void get_the_most_expensive_HONDA_car() {
        //TODO
        Comparator<Car> compareByPriceDescending = comparing(Car::getPriceInEuro).reversed();

        Car mostExpensiveHonda = cars.stream()
                .filter(isHonda)
                .sorted(compareByPriceDescending)
                .findFirst().get();

        System.out.println(mostExpensiveHonda);
    }

    @Test
    public void get_the_most_expensive_AUDI_price() {
        //TODO
        Comparator<Car> compareByPrice = comparing(Car::getPriceInEuro);

        Car mostExpensiveAudiCar = cars.stream()
                .filter(isAudi)
                .sorted(compareByPrice.reversed())
                .findFirst().get();

        System.out.println(mostExpensiveAudiCar.getPriceInEuro());
    }

    @Test
    public void get_the_most_expensive_AUDI_model() {
        //TODO
        // look upper
    }

    @Test
    public void get_prices_average() {
        //TODO
        System.out.println(
                cars.stream()
                    .mapToDouble(Car::getPriceInEuro)
                    .average().getAsDouble());
    }

    @Test
    public void get_AUDI_prices_average() {
        //TODO
        System.out.println(
                cars.stream()
                        .filter(isAudi)
                        .mapToDouble(Car::getPriceInEuro)
                        .average().getAsDouble());
    }

    @Test
    public void get_a_list_with_car_counts_for_each_CarProducer() {
        //TODO
        Map<String, Long> carCountByCarProducer = cars.stream()
                .collect(Collectors.groupingBy(
                        Car::getModelName, // key supplier - Supplier<CarProducer>
                        Collectors.counting()   // value reducer
                ));

        System.out.println(carCountByCarProducer);
        System.out.println("Models: " + carCountByCarProducer.keySet());
        System.out.println("Counts: " + carCountByCarProducer.values());
    }

/*    @Test
    public void get_a_list_with_prices_average_for_each_CarProducer() {
        //TODO
        Map<CarProducer, Double> pricesAverageByCarProducer = cars.stream()
                .collect(Collectors.groupingBy(
                    Car::getCarProducer,
                    Collectors.averagingDouble(Double::doubleValue)));
    }*/

    private void printList(Collection<?> cars) {
        //cars.stream().forEach(System.out::println);
        //cars.forEach(System.out::println);
        // Consumer<Car> lamba: Car -> void
        cars.forEach(
                car -> System.out.println(car)
        );
    }
}
