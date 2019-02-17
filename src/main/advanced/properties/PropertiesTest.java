package main.advanced.properties;

import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) {

        Properties allProperties = System.getProperties();
        allProperties.forEach(
                (name, value) -> System.out.println(name + "=" + value));

        System.out.println("\nUser dir:" +
                System.getProperty("user.dir"));

        System.out.println("\nCustom defined property: " +
                System.getProperty("custom"));
    }
}
