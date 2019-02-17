package main.advanced.properties;

import java.util.Properties;
import java.util.function.BiConsumer;

public class PropertiesTest {

    private final static String WRONG_NUMBER_MESSAGE =  "WRONG NUMBER!";
    private final static String FAV_NUMBER_MESSAGE =  "Dan's favourite number";


    public static void main(String[] args) {

        Properties allProperties = System.getProperties();
        BiConsumer b; // CTRL + B on BiConsumer
        // (T t, U u) -> void
        /*allProperties.forEach(
                (name, value) -> System.out.println(name + "=" + value));*/

        System.out.println("\nUser dir:" +
                System.getProperty("user.dir"));

        final String customProp = System.getProperty("custom");
        System.out.println("\nCustom defined property: " +
                customProp);

        if(customProp == null){
            System.out.println(WRONG_NUMBER_MESSAGE);
            return;
        }

        if(customProp.equals("1111")){
            System.out.println(FAV_NUMBER_MESSAGE);
        }
        else{
            System.out.println(WRONG_NUMBER_MESSAGE);
        }
    }
}
