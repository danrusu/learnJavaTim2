package main.advanced.test_19_02_09;

import static main.advanced.test_19_02_09.Number.*;
import org.junit.jupiter.api.Test;/**/


import java.util.Arrays;
import java.util.List;

public class NumberDemo {

    public static void main(String[] args) {
        System.out.println(Number.ONE); // static access
    }

    @Test
    public void all_enum_values_test(){
        Number[] values = Number.values();
        System.out.println(values);
        System.out.println(Arrays.asList(values));
    }

    @Test
    public void string_to_enum_value_test(){
        String numberThree = "three";
        //Number nrThree = Number.valueOf(numberThree); // will throw
        Number nrThree = Number.valueOf(numberThree.toUpperCase());
    }

    @Test
    public void print_enum_value_test(){
        System.out.println(TWO);
    }

    @Test
    public void enum_get_type_test(){
        System.out.println(
                ONE.getClass().getSimpleName());
    }

    @Test
    public void get_int_value_test(){

        String one = ONE.toString();
        String oneName = ONE.name();

        System.out.println(one + " : " + one.getClass().getSimpleName());
        System.out.println(oneName);

        Integer oneValue = Integer.parseInt(one);
        //Integer value = Integer.parseInt(oneName); // will throw NumberFormatException
        System.out.println(oneValue + " : " + oneValue.getClass().getSimpleName());
    }
}
