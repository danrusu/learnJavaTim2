package main.advanced.optionals;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import static main.advanced.streams.Cars.Car;
import static main.advanced.streams.Cars.CarProducer.*;

/*You can see an Optional as a stream with one or no element within.
You can have Optionals of objects or of primitives.
*/
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

    @Test
    public void primitive_optionl_test(){

        double doubleNumber = 100d;
        OptionalDouble optionalDouble = OptionalDouble.of(doubleNumber);

        double optionalContent = optionalDouble.getAsDouble();
        System.out.println(optionalContent);
    }

    private String getFirstWordOrDefaultText(List<String> words, String defaultText){

        return words.stream().findFirst().orElse(defaultText);
    }

    @Test
    public void test_empty() {

        String firstWordNotEmpty = getFirstWordOrDefaultText(
                List.of("one", "two", "apple"),
                "");
        System.out.println(firstWordNotEmpty);

        String firstWord = getFirstWordOrDefaultText(
                List.of(),
                "no word");
        System.out.println(firstWord);

        System.out.println(getFirstWordOrDefaultText(
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

        emptyCarGarage.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("empty garage"));

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
    }

}
