package main.advanced.objectOverrides;

import java.util.Objects;

public class Employee implements Cloneable {

    private String name;
    private int age;
    private Employer employer;

    public Employee(String name, int age, Employer employer) {
        this.name = name;
        this.age = age;
        this.employer = employer;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Employer getEmployer() {
        return employer;
    }

    // Overrides from Object

    // if you override equals() you must override hashCode()
    @Override
    public boolean equals(Object other) {

        // common part to all equals implementations
        if (this == other) return true;

        if (other == null) return false;
        if (false == (other instanceof Employee))return false;
        // end common part

        Employee otherEmployee = (Employee)other;

        //return this == otherEmployee;
        return Objects.equals(name, otherEmployee.name)
                && (age == otherEmployee.age)
                && Objects.equals(employer, otherEmployee.employer);
    }

    // if you override equals() you must override hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(name, age, employer);
    }

    @Override
    public Object clone() {
        return new Employee(name, age, employer);
    }

    @Override
    public String toString() {
        return String.join(" | ",
                name,
                age + "",
                employer.name());
    }
}
