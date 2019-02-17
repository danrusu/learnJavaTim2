package main.advanced.junit;

import skillsTest.test_19_02_17.Person;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonOperation {

    // get persons by age > 30
    static List<Person> filterByAgeGt30(List<Person> persons) {

        final Predicate<Person> isOlderThan30 = person -> person.getAge() > 30;

        return persons.stream()
                .filter(isOlderThan30)
                .collect(Collectors.toList());
    }

    // get average age
    static Long getAverageAge(List<Person> persons){
        return 0L;
    }

}
