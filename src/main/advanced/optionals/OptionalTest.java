package main.advanced.optionals;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static main.advanced.streams.Cars.Car;
import static main.advanced.streams.Cars.CarProducer.*;


public class OptionalTest {

    String text;

    @Test
    public void test_nullable(){

        Optional<String> optionalText = Optional.ofNullable(text);

        String upperCaseTest = optionalText
                .orElse("ifEmptyOptional")
                .toUpperCase();

        System.out.println(upperCaseTest);
    }

    private String getFirstWord(List<String> words, String defaultText){

        return words.stream().findFirst().orElse(defaultText);
    }

    @Test
    public void test_empty() {
        String firstWordNotEmpty = getFirstWord(
                List.of("one", "two", "apple"),
                "");
        System.out.println(firstWordNotEmpty);

        String firstWord = getFirstWord(
                List.of(),
                "no word");
        System.out.println(firstWord);

        System.out.println(getFirstWord(
                Collections.emptyList(),
                "eeempty"));
    }


    @Test
    public void test_optional_methods(){

        Optional<Car> carGarage = Optional.of(new Car(
                PORSCHE,
                "Maican",
                70000));

        Optional<Car> emptyCarGarage = Optional.empty();

        System.out.println("There is a car in carGarage: "
                + carGarage.isPresent());

        System.out.println("There is a car in emptyCarGarage: "
                + emptyCarGarage.isPresent());

        System.out.println(carGarage.get());
        emptyCarGarage.ifPresent(System.out::println); // will not print anything

 /*
 From Optional:

 public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) {
            if (value != null) {
                action.accept(value);
            } else {
                emptyAction.run();
            }
        }
        */

        emptyCarGarage.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("empty garage"));

    }

}
