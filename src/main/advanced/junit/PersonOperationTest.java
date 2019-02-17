package main.advanced.junit;

import org.junit.jupiter.api.*;
import skillsTest.test_19_02_17.Person;

import java.util.Collections;
import java.util.List;

public class PersonOperationTest {

    static List<Person> persons;
    static List<Person> personsEmptyList;

    static List<Person> EXPECTED_PERSONS_GT30;
    static List<Object> EXPECTED_PERSONS_GT30_EMPTY;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
        persons = List.of();
        personsEmptyList = List.of();
        EXPECTED_PERSONS_GT30 = List.of();
        EXPECTED_PERSONS_GT30_EMPTY = List.of();
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }

    @BeforeEach
    public void beforeEach() {

        System.out.println("test data input initialization");
        persons = List.of(
                new Person("Doug", 50),
                new Person("Diana", 37),
                new Person("Mark", 29),
                new Person("Don", 50),
                new Person("Carmen", 18)
        );

        personsEmptyList = Collections.emptyList();

        // expected data
        EXPECTED_PERSONS_GT30 = List.of(
                new Person("Doug", 50),
                new Person("Diana", 37),
                new Person("Don", 50));

        EXPECTED_PERSONS_GT30_EMPTY = Collections.emptyList();
    }

    @AfterEach
    public void afterEach(){
        System.out.println("afterEach test");
    }


    @Nested
    @DisplayName("#filter persons by age test !!!!!")

    public class FilterByAgeGtTest {

        @Test
        @Tag("filter20years")
        public void test() {
            System.out.println("test");
            List<Person> personsGt30 = PersonOperation.filterByAgeGt30(persons);

            Assertions.assertEquals(
                    EXPECTED_PERSONS_GT30.toString(),  // expected
                    personsGt30.toString());           // actual
        }

        @Test
        public void empty_list_test() {
            System.out.println("empty_list_test");
            List<Person> personsGt30Empty = PersonOperation.filterByAgeGt30(personsEmptyList);

            Assertions.assertEquals(
                    EXPECTED_PERSONS_GT30_EMPTY.toString(),  // expected
                    personsGt30Empty.toString());            // actual
        }
    }

    @Test
    @Tag("filter20years")
    public void average_age_test() {
        System.out.println("average_age_test");
    }

}
