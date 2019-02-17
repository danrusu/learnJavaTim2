package main.advanced.streams;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static main.advanced.streams.Cars.Car;
import static main.advanced.streams.Cars.Car.*;
import static main.advanced.streams.Cars.CarProducer;
import static main.advanced.streams.Cars.CarProducer.AUDI;
import static main.advanced.streams.Cars.CarProducer.PORSCHE;

public class CarsTest {

    List<Car> cars = new Cars().getCars();

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

        Predicate<Car> isFordOrHonda = isFord.or(isHonda);

        Predicate<Car> isNotAudiOrPorsche = isPorsche.negate()
                .and(isAudi.negate());

        Predicate<Car> isNotAudiOrPorsche_static = Predicate.not(isPorsche)
                .and(Predicate.not(isAudi));

        // isFordOrHonda, isNotAudiOrPorsche, isNotAudiOrPorsche_static - are the same filters
        // replace next filter with any of the above filters to see the same result
        List<Car> fordsAndHondas = cars.stream()
                .filter(isFordOrHonda)
                .collect(toList());

        printList(fordsAndHondas);
    }

    @Test
    public void get_a_list_of_all_AUDI_models() {

        List<String> audiModels = cars.stream() // stream of Car
                .filter(isAudi) // stream of Car
                .map(car -> car.getModelName())
                //.map(Car::getModelName) // stream of String
                .collect(toList());

        printList(audiModels);
    }

    @Test
    public void get_a_list_of_all_Ford_models_and_prices() {

        // the list must look like: [ "Fiesta:11000.0", "Focus:21000.0", "Galaxy:35000.0" ]
        Function<Car, String> carToModelAndPrice = car ->
                car.getModelName() + ":" + car.getPriceInEuro();

        List<String> fordModelsAndPrices = cars.stream()
                .filter(isFord) // stream of Car
                .map(carToModelAndPrice) // stream of String
                .collect(toList());

        System.out.println(fordModelsAndPrices);
    }

    @Test
    public void get_a_collection_of_all_unique_CarProducers() {

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

        Set<String> carProducersSet = cars.stream()
                .map(Car::getCarProducer)
                //.map(carProducer -> carProducer.toString())
                .map(CarProducer::toString)
                .collect(toSet());

        String carProducersString = carProducersSet.stream()
                .collect(joining(" "));

        System.out.println(carProducersString);
    }

    @Test
    public void get_a_collection_of_all_unique_CarProducers_that_have_cars_costing_over_100000_euro() {

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

        Car cheapestAudiCar = cars.stream()
                .filter(isAudi)
                .sorted(compareByPrice)
                .findFirst().get();

        System.out.println(cheapestAudiCar);
    }

    @Test
    public void get_Ford_models_cheaper_than_20000_euro() {

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

        Comparator<Car> compareByPriceDescending = compareByPrice.reversed();

        Car mostExpensiveHonda = cars.stream()
                .filter(isHonda)
                .sorted(compareByPriceDescending)
                .findFirst().get();

        System.out.println(mostExpensiveHonda);
    }

    @Test
    public void get_the_most_expensive_AUDI_price() {

        Car mostExpensiveAudiCar = cars.stream()
                .filter(isAudi)
                .sorted(compareByPrice.reversed())
                .findFirst().get();

        System.out.println(mostExpensiveAudiCar.getPriceInEuro());
    }

    @Test
    public void get_the_most_expensive_AUDI_model() {

        Car mostExpensiveAudiCar = cars.stream()
                .filter(isAudi)
                .sorted(compareByPrice.reversed())
                .findFirst().get();

        System.out.println(mostExpensiveAudiCar.getPriceInEuro());
    }

    @Test
    public void get_prices_average() {

        double pricesAverage = cars.stream()
                .mapToDouble(Car::getPriceInEuro)
                .average().getAsDouble();

        System.out.println(pricesAverage);
    }

    @Test
    public void get_AUDI_prices_average() {

        double audiPricesAverage = cars.stream()
                .filter(isAudi)
                .mapToDouble(Car::getPriceInEuro)
                .average().getAsDouble();

        System.out.println(audiPricesAverage);
    }

    @Test
    public void get_a_list_with_car_counts_for_each_CarProducer() {

        Map<String, Long> carCountByCarProducer = cars.stream()
                .collect(groupingBy(
                        Car::getModelName,     // classifier
                        counting()  // downstream
                ));

        System.out.println(carCountByCarProducer);
        System.out.println("Models: " + carCountByCarProducer.keySet());
        System.out.println("Counts: " + carCountByCarProducer.values());
    }

    @Test
    public void get_a_list_with_prices_average_for_each_CarProducer() {

        Map<CarProducer, Double> pricesAverageByCarProducer = cars.stream()
                .collect(groupingBy(
                        Car::getCarProducer,                    // classifier (key)
                        averagingDouble(Car::getPriceInEuro))); // downstream (value)

        System.out.println(pricesAverageByCarProducer);
    }

    @Test
    public void get_partitions_of_cars_for_50000euro_price() {
        Map<Boolean, List<Car>> partitions = cars.stream()
                .collect(partitioningBy(
                        car -> car.getPriceInEuro() > 50000
                ));

        printMap(partitions);
    }


    @Test
    public void numbers_partition_test(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> biggerThan4 = number -> number > 4;

        Map<Boolean, List<Integer>> partitions = numbers.stream()
                .collect(partitioningBy(
                        biggerThan4
                ));

        System.out.println(partitions);

        System.out.println("Numbers > 4:" + partitions.get(true));
        System.out.println("Numbers <= 4:" + partitions.get(false));
    }

    @Test
    public void get_partitions_of_cars_for_80000euro_grouped_byName() {

        final Predicate<Car> isPriceBiggerThan80k = car -> car.getPriceInEuro() > 80000;

        Map<Boolean, Map<CarProducer, List<Car>>> groupedPartitions = cars.stream()
                .collect(partitioningBy(
                        isPriceBiggerThan80k,
                        groupingBy(Car::getCarProducer)
                ));

        printMap(groupedPartitions);

        System.out.println("\nOver 80K\n");

        // print Cars producers which have cars over 80K
        final Map<CarProducer, List<Car>> carProducerOver80k = groupedPartitions.get(true);
        System.out.println(carProducerOver80k.keySet());
        System.out.println();

        System.out.println("Models over 80k:");
        Collection<List<Car>> carListsOver80k = groupedPartitions.get(true).values();
        Consumer<Car> printCarModel = car -> System.out.println(car.getModelName());

        carListsOver80k.forEach(
                carsList -> carsList.forEach(printCarModel));
        System.out.println();

        // print cars over 80K
        System.out.println(groupedPartitions.get(true).values());

        System.out.println("\nUnder 80K\n");
        // print Cars producers which have cars under 80K
        System.out.println(groupedPartitions.get(false).keySet());
        System.out.println();
        // print cars under 80K
        System.out.println(groupedPartitions.get(false).values());
    }

    private void printList(Collection<?> cars) {

        //cars.stream().forEach(System.out::println);
        //cars.forEach(System.out::println);

        // Consumer<Car> lamba: Car -> void
        cars.forEach(
                car -> System.out.println(car)
        );
    }

    private void printMap(Map<?, ?> map) {
        map.entrySet().stream()
                .forEach(entry -> System.out.println(
                        entry.getKey() + " = " + entry.getValue()));
    }
}
