package main.advanced.brokenMap;

import java.util.Objects;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) return true;

        if (other == null) return false;
        if (!(other instanceof Person))return false;

        Person otherPerson = (Person)other;

        return this.name.equals(otherPerson.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.name);
    }
}
