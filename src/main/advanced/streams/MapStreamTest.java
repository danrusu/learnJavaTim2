package main.advanced.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStreamTest {

    static Map<Integer, String> namesById = Map.of(
            1000, "Dan",
            1001, "Dorina",
            1002, "Maria",
            1003, "Tania",
            1004, "Adela"
    );

    public static void main(String[] args) {

        System.out.println("Keys using");
        namesById.keySet().forEach(System.out::println);

        System.out.println("Values: ");
        namesById.values().forEach(System.out::println);

        System.out.println("Entries: ");
        namesById.entrySet().forEach(System.out::println);

        // task get a List of "1000:Dan", "1001:Dorina" ...
        List<String> keyAndName = namesById.entrySet().stream() // stream of Entry
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.toList());

        System.out.println(keyAndName);
    }
}
