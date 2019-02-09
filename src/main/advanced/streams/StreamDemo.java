package main.advanced.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamDemo {

    @Test
    public void stream_test() {
        List<Integer> numbers = List.of(
                1, 40, 50, 27,
                4, -3, -9, 8,
                7, 6, 8, 5);

        Stream<Integer> numberStream = numbers.stream();

        List<Integer> smallerThan20List = numbers.stream()
                .filter(isSmallerThan20)
                .map(duplicate)
                .collect(toList());

        System.out.println(smallerThan20List);
    }

    private Function<Integer, Integer> duplicate = number -> number * 2;

    private Predicate<Integer> isSmallerThan20 = number -> number > 20;

}
