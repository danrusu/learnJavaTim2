package main.advanced.collections;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {


    @Test
    public void create_unmodifiable_set_test(){
        // will throw java.lang.IllegalArgumentException: duplicate element: 2
        //Set<Integer> uniqueNumbers = Set.of(1, 2, 3, 2, 1);
        Set<Integer> uniqueNumbers = Set.of(1, 2, 3);
        //uniqueNumbers.add(4); // will throw java.lang.IllegalArgumentException
        System.out.println(uniqueNumbers);
    }

    @Test
    public void create_new_tree_set_test(){
        Set<Integer> numbersSet = new TreeSet<>();
        System.out.println("Initial set: " + numbersSet);

        numbersSet.add(2);
        numbersSet.add(5);
        numbersSet.add(1);
        numbersSet.add(-1);

        System.out.println(numbersSet);


        String s = "home";
        System.out.println(s.hashCode());
    }


    @Test
    public void create_new_tree_set_string_test(){
        Set<String> newNamesSet = Set.of("NewName");

        Set<String> names = new TreeSet<>(); // ordered
        //Set<String> numbersSet = new HashSet<>(); // unordered

        List<String> employeesList = List.of(
                "George",
                "Carmen",
                "George",
                "Carmen",
                "Adela",
                "Maria",
                "Tania",
                "George"
        );

        names.add("Maria");
        names.add("Tania");
        names.add("Adela");
        names.add("Adela"); // element is not added; add returns false

        System.out.println(names);

        // add a collection
        System.out.println("Add collections");
        names.addAll(employeesList);
        names.addAll(newNamesSet);

        System.out.println(names);

   /*     for(String name : names){
            System.out.println(name.toUpperCase());
        }
*/
    }
}
