package main.advanced.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static main.advanced.streams.Cars.Car;
import static main.advanced.streams.Cars.CarProducer.PORSCHE;
import static java.util.stream.Collectors.toList;

public class CarsTest {

    List<Car> cars = new Cars().getCars();

    // Using the above list of Car (from main.advanced.streams.Cars)
    // solve the following tasks (TODOs) using the java Stream API
    // (you can also try a classic approach - for loops):

    @Test
    public void get_all_porsche_cars(){

        List<Car> porscheCars = cars.stream()
                .filter(car -> car.getCarProducer().equals(PORSCHE))
                .collect(toList());

        // print porscheCars list to check if it is correct
        System.out.println(porscheCars);

        // also you can extract the Predicate to a variable with a relevant name
        //Predicate<Car> isPorsche = car -> car.getCarProducer().equals(PORSCHE);
    }

    @Test
    public void get_a_list_of_all_AUDI_cars(){
        //TODO
    }

    @Test
    public void get_a_list_of_all_FORD_and_HONDA_cars(){
        //TODO
    }

    @Test
    public void get_a_list_of_all_AUDI_models(){
        //TODO
    }

    @Test
    public void get_a_list_of_all_Ford_models_and_prices(){
        //TODO
        // the list must look like: [ "Fiesta:11000", "Focus:21000", Galaxy", 35000 ]
    }

    @Test
    public void get_a_collection_of_all_unique_CarProducers_test(){
        //TODO
    }

    @Test
    public void get_a_string_with_all_unique_CarProducers_separated_by_space(){
        //TODO
        // hint: use Collectors.joining
    }

    @Test
    public void get_a_collection_of_all_unique_CarProducers_that_have_cars_costing_over_100000_euro(){
        //TODO
    }

    @Test
    public void get_cheapest_car(){
        //TODO
    }

    @Test
    public void get_cheapest_AUDI_car(){
        //TODO
    }

    @Test
    public void get_Ford_models_cheaper_than_20000_euro(){
        //TODO
    }

    @Test
    public void get_the_most_expensive_car(){
        //TODO
    }

    @Test
    public void get_car_models_more_expensive_than_100000_euro(){
        //TODO
        // the list must look like: [ "PORSCHE Panamera", "AUDI S8" ]
    }

    @Test
    public void get_the_most_expensive_HONDA_car(){
        //TODO
    }

    @Test
    public void get_the_most_expensive_AUDI_price(){
        //TODO
    }

    @Test
    public void get_the_most_expensive_AUDI_model(){
        //TODO
    }

    @Test
    public void get_prices_average(){
        //TODO
    }

    @Test
    public void get_AUDI_prices_average(){
        //TODO
    }

    @Test
    public void get_a_list_with_car_counts_for_each_CarProducer(){
        //TODO
    }

    @Test
    public void get_a_list_with_prices_average_for_each_CarProducer(){
        //TODO
    }
}
