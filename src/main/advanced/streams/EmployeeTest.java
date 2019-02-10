package main.advanced.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.TileObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static main.advanced.streams.City.*;
import static main.advanced.streams.Employer.*;
import static main.advanced.streams.TechnicalLevel.*;

public class EmployeeTest {

    Employee employee1 = new Employee("Dan", 20, BRASOV, CONSIGNOR, BEGINNER);

    List<Employee> employees = List.of(
            employee1,
            new Employee("Marian", 30, TIMISOARA, AZETS, BEGINNER),
            new Employee("Tom", 32, TIMISOARA, AZETS, SENIOR),
            new Employee("Artur", 38, TIMISOARA, VISMA, SENIOR),
            new Employee("Carmen", 24, TIMISOARA, AZETS, SENIOR),
            new Employee("Maria", 25, BUCURESTI, CONSIGNOR, BEGINNER),
            new Employee("Tania", 32, IASI, CONSIGNOR, BEGINNER),
            new Employee("Adela", 30, BRASOV, VISMA, SENIOR),
            new Employee("Giani", 39, IASI, CONSIGNOR, SENIOR),
            new Employee("Yvone", 30, BRASOV, VISMA, BEGINNER),
            new Employee("Ariana", 18, BUCURESTI, CONSIGNOR, BEGINNER),
            new Employee("Gheorghe", 40, BRASOV, CONSIGNOR, SENIOR),
            new Employee("Vasile", 32, CLUJ, CONSIGNOR, BEGINNER),
            new Employee("Bill", 35, TIMISOARA, VISMA, GURU),
            new Employee("Nicolae", 20, IASI, IBM, ADVANCED));

    @Test
    public void consumer_test() {
        // Consumer
        //  void accept(Employee employee);
        // lambda: employee -> void

        System.out.println("Employees count: " + employees.size());

        /*Stream<Employee> employeeStream = employees.stream();
        employeeStream.forEach(printEmployee2); // declarative*/

        // classic Consumer instantiation
        /*employees.stream().forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                System.out.println(employee);
            }
        });*/

        // lambda Consumer instantiation
        //employees.stream().forEach(employee -> System.out.println(employee));

        // Consumer by method reference
        Stream<Employee> employeeStream = employees.stream();
        employeeStream.forEach(System.out::println);
        // stream is consumed; it cannot be consumed again

        //employeeStream.forEach(System.out::println);
        // will throw java.lang.IllegalStateException: stream has already been operated upon or closed

        Consumer<Employee> printEmployee =
                employee -> System.out.println(employee);

        Consumer<Employee> printEmployee2 = System.out::println;
    }

    @Test
    public void filter_test() {
        // task: extract a list of all SENIORs from initial employees list
        // hint: use stream filter & collect functions
        // extract the filter to a function

        /*
        java.util.function.Predicate<T>
        abstract method: boolean test(T t);
        lambda:          (T t) -> boolean
        T = Employee
        */

        Predicate<Employee> isSenior =
                employee -> employee.getTehnicalLevel().equals(SENIOR);

        List<Employee> seniors = employees.stream() // stream of Employee
                .filter(isSenior) // stream of Employee
                .collect(toList());
        //.forEach(System.out::println);

        System.out.println("seniors: ");
        printList(seniors);

        //classic
        List<Employee> seniorList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getTehnicalLevel().equals(SENIOR)) {
                seniorList.add(employee);
            }
        }

        System.out.println("seniorList: ");
        printList(seniorList);
    }

    @Test
    public void mapper_test() {
        // get a list of all employee names
        // hint: use stream filter & collect functions
        // extract the mapper to a function
        System.out.println("Employee list size: " + employees.size());

        Function<Employee, String> employeeToName = employee -> employee.getName();
        Function<Employee, String> employeeToName2 = Employee::getName;

        List<String> names = employees.stream()// stream of Employee
                /*.map(new Function<Employee, String>() {
                    @Override
                    public String apply(Employee employee) {
                        return employee.getName();
                    }
                })*/ // stream of String

                // (Employee employee) -> String
                .map(employeeToName)
                .collect(toList());

        // one line
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(toList());

        System.out.println("Name list size: " + employeeNames.size());

        System.out.println(employeeNames);
    }

    private Predicate<Employee> hasTechnicalLevel(TechnicalLevel technicalLevel){
            return employee -> employee.getTehnicalLevel().equals(technicalLevel);
    }

    @Test
    public void filter_map_collect_test() {

        // task get all beginners names
        List<String> beginnersNames = employees.stream() // stream of Employee
                .filter(hasTechnicalLevel(BEGINNER)) // stream of Employee
                .map(Employee::getName)
                .collect(toList());

        System.out.println("Beginners: " + beginnersNames);
    }

    Predicate<Employee> isFromTimisoara =
            employee -> employee.getCity().equals(TIMISOARA);

    private Predicate<Employee> isFromCity(City city){
        return employee -> employee.getCity().equals(city);
    }

    @Test
    public void filter_map_collect_tes2() {
        // task get all beginners names from Timisoara
        // steps:
        // 1 filter BEGINNERS,
        // 2 filter from TIMISOARA,
        // 3 collect names
        employees.stream()
                .filter(isFromCity(BUCURESTI))
                .forEach(System.out::println);

        List<String> beginnersFromTimisoara = employees.stream()
                .filter(hasTechnicalLevel(BEGINNER))
                .filter(isFromCity(BUCURESTI))
                .map(Employee::getName)
                .collect(toList());

        System.out.println("Beginners from timisoara: " + beginnersFromTimisoara);
    }

    @Test
    public void cities_with_seniors_test(){
        // get cities that contain seniors from employees list
        // steps
        // 1 filter by senior
        // 2 map from Employee to City
        // 3 collect cities
        Set<City> citiesWithSeniors = employees.stream()
                .filter(hasTechnicalLevel(SENIOR))
                .map(employee -> employee.getCity())
                //.map(Employee::getCity)
                .collect(toSet());

        System.out.println(citiesWithSeniors);
        System.out.println("Cities with seniors count: " + citiesWithSeniors.size());

    }

    private void printList(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee); // imperative
        }
    }

    @Test
    public void get_average_age_test(){

        double average = employees.stream() // stream of Employees
                .map(Employee::getAge) // stream of Integers (ages)
                .mapToInt(i -> i)      // int stream
                .average()
                .getAsDouble();

        System.out.println("Average age of employees: " + average);
    }

    @Test
    public void primitives_streams_test(){
        IntStream numbers = IntStream.rangeClosed(1, 10);

        IntStream.rangeClosed(1, 10).forEach(System.out::println);

        final int sum1To10 = IntStream.rangeClosed(1, 10).sum();
        final double average1To5 = IntStream.range(1, 6).average().getAsDouble();

        System.out.println("Sum 1..10: " + sum1To10);
        System.out.println("Average 1..5: " + average1To5);
    }
}