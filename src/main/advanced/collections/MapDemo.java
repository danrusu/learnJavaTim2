package main.advanced.collections;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.util.Map.Entry;

public class MapDemo {

    @Test
    public void create_new_unmodifiable_map_test(){

        Map<Integer, String> userNameById = Map.of(
                1234, "Dan",  //key1, value1
                1111, "Jane", //key2, value2
                1000, "Dan"
        );

        // userNameById.put(4321, "Wrong"); // will throw

        System.out.println("Map size: " + userNameById.size());
        System.out.println(userNameById);

        System.out.println("Key=1111, value=" + userNameById.get(1111));
    }

    @Test
    public void create_new_map_test(){

        Map<Integer, String> userNameById = new TreeMap<>();
        userNameById.put(1234, "Dan");
        userNameById.put(1111, "Jane");
        userNameById.put(1000, "Dan");
        userNameById.put(1234, "Carmen");

        System.out.println(userNameById);
        System.out.println("Keys: " + userNameById.keySet());
        System.out.println("Values " + userNameById.values());

        Set<Entry<Integer, String>> entrySet = userNameById.entrySet();
        System.out.println("Entry iteration:");
        for (Entry entry : entrySet){
            System.out.println(entry.getKey()
                    + " = " + entry.getValue());
        }

        System.out.println("Keys iteration:");
        for (Integer key : userNameById.keySet()){
            System.out.println(key
                    + " = " + userNameById.get(key));
        }
    }

    @Test
    public void create_new_map_from_unmodifiable_map_test() {

        Map<Integer, String> userNameByIdUnmodifiable = Map.of(
                1234, "Dan",  //key1, value1
                1111, "Jane", //key2, value2
                1000, "Dan"
        );

        Map<Integer, String> userNameById = new TreeMap<>();
        System.out.println("Map after creation: " + userNameById);

        userNameById.putAll(userNameByIdUnmodifiable);
        System.out.println("Map after adding userNameByIdUnmodifiable: " + userNameById);

        userNameById.put(1000, "Tom");
        System.out.println("Map after putting (1111,TOM) entry: " + userNameById);

        userNameById.put(5555, "Josh");
        System.out.println("Map after putting (5555, Josh) entry: " + userNameById);
    }

}
