package main.advanced.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest{

    @Test
    public void intstream_to_stream_of_integers_test(){

        IntStream intStream = IntStream.rangeClosed(1, 10);

        Stream<Integer> streamOfIntegers = intStream.mapToObj(i -> i);

        // get double list from 1 to 10
        List<Double> doubles1To10 = IntStream.rangeClosed(1, 10) // IntStream
                .mapToObj(i -> i) // Stream<Integer>
                //.map(integer -> integer.doubleValue())
                .map(Integer::doubleValue)
                .collect(Collectors.toList());

        System.out.println(doubles1To10);
    }

    @Test
    public void stream_of_integers_to_intStream_test(){

        Stream<Integer> streamOfIntegers = Stream.of(1,2,3,4,5,6,7,8, 9, 10);

        IntStream intStream = streamOfIntegers.mapToInt(i -> i);
    }

    @Test
    public void peek_test(){
        int sum = IntStream.rangeClosed(1, 10)
                .peek(intValue -> System.out.println(intValue))
                .sum();

        System.out.println("Sum: " + sum);
    }

    @Test
    public void join_list_words_test(){

        List<String> sentenceWords = List.of(
                "The",
                "quick",
                "brown",
                "fox",
                "jumps",
                "over",
                "the",
                "lazy",
                "dog");

        System.out.println("Word:" + sentenceWords);

        String sentence = sentenceWords.stream()
                .collect(Collectors.joining(" "));

        System.out.println("Sentence: " +sentence);
    }

    @Test
    public void supplier_test(){

        final Employee employee = new Employee(
                "Bill",
                40,
                City.TIMISOARA,
                Employer.IBM,
                TechnicalLevel.GURU);

        // Supplier
        // Employee get();
        // lambda: () -> Employee
        Supplier<Employee> supplierClassic = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return employee;
            }
        };

        Supplier<Employee> supplier = () -> employee;
        // TODO ???
        //Supplier<Employee> supplier2 = Employee::new;

        System.out.println(supplier.get());
    }
}
