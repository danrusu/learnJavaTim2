package main.advanced.brokenMap;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class BrokenMapDemo {

    @Test
    public void broken_map_test() {

        Person person = new Person("John");

        HashMap<Person, Integer> ageByPersonMap = new HashMap<>();

        ageByPersonMap.put(person, 40);

        System.out.println("Initial person: " + person);
        System.out.println("Person name: " + person.getName());
        System.out.println("Initial map: " + ageByPersonMap);
        System.out.println("Map contains key " + person + " : " + ageByPersonMap.containsKey(person));
        System.out.println("Initial age from map: " + ageByPersonMap.get(person));


        System.out.println("-----------------------");

        String newName = "Jane";
        System.out.println("Change person name to" + newName);
        person.setName(newName);

        System.out.println("Person: " + person);
        System.out.println("Person name: " + person.getName());
        System.out.println("Map: " + ageByPersonMap);
        System.out.println("Map contains key " + person + " : " + ageByPersonMap.containsKey(person));
        // the following line result is due to internal HashMap implementation
        System.out.println("Age from map: " + ageByPersonMap.get(person));
    }
}
