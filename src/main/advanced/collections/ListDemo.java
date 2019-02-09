package main.advanced.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {

    @Test
    public void unmodifiable_list_iteration1_test(){
        List<Integer> numbers = List.of(1 ,2 ,3, 2, 1); // unmodifiable list
        System.out.println("Size: " + numbers.size());
        System.out.println(numbers);

        //numbers.add(5); // throws java.lang.UnsupportedOperationException
        for (int index = 0; index < numbers.size(); index++) {
            System.out.println("Index: " + index
                    + " Value: " + numbers.get(index));
        }
    }

    @Test
    public void unmodifiable_list_iteration2_test(){
        List<Integer> numbers = List.of(1 ,2 ,3, 2, 1);

        for(Integer element : numbers){
            System.out.print(element + " ");
        }
    }

    @Test
    public void create_new_list_and_apply_methods_test(){

        List<String> names = new ArrayList<>();

        names.add("John"); // index 0
        names.add("Jane"); // index 1
        names.add("Jack"); // index 2
        System.out.println("Initial list: " + names);

        System.out.println("add Tom at index 1");
        names.add(1, "Tom");
        System.out.println("List: " + names);

        List<String> additionalNames = List.of("Maria", "Tania", "Adela");
        System.out.println("Add additionalNames to names");
        names.addAll(additionalNames);
        System.out.println("List: " + names);

        System.out.println("Remove last element");
        String removedName = names.remove(names.size()-1);
        System.out.println("Removed name: " + removedName);

        System.out.println(names);
    }

    @Test
    public void create_new_array_test(){
        String[] namesArray = new String[]{"John", "Jane", "Jack"};
        //namesArray[4] = "Tom"; // throws ArrayIndexOutOfBoundsException
        System.out.println("Length: " + namesArray.length);
        System.out.println("Initial array:" + Arrays.toString(namesArray));

        // print array with loop
        for(String name : namesArray){
            System.out.println(name);
        }

        namesArray[1] = "Tom";
        System.out.println("Modified array:" + Arrays.toString(namesArray));
    }

    @Test
    public void filter_list_test(){
        List<Integer> numbers = List.of(1, 40, 50 ,27, 4, 8, 7, 6);
        for(int number : numbers){
            if(number > 20){
                System.out.print(number + " ");
            }
        }
    }

    @Test
    public void collect_list_test(){
        int sum = 0;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for(int number : numbers){
            sum = sum + number;
        }
        System.out.println("Sum: " + sum);
    }
    
    @Test
    public void list_min_test(){
        List<Integer> numbers = List.of(
                1, 40, 50 ,27,
                4, -3, -9,  8,
                7,  6,  8,  5);

        int min = Integer.MAX_VALUE;
        System.out.println("Integer max: " + min);
        System.out.println("Integer min: " + Integer.MIN_VALUE);

        for(int number :numbers){
            if(number < min){
                min = number;
            }
        }

        System.out.println("Min form list: " + min);
    }

    @Test
    public void list_max_test(){
        List<Integer> numbers = List.of(
                1, 40, 50 ,27,
                4, -3, -9,  8,
                7,  6,  8,  5);

        int max = Integer.MIN_VALUE;

        for(int number :numbers){
            if(number > max){
                max = number;
            }
        }

        System.out.println("Max form list: " + max);
    }

    @Test
    public void list_average_test(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = 0;
        for(int number : numbers){
            sum = sum + number;
        }

        double average = (double)sum / numbers.size();
        System.out.println("Average: " + average);
    }

    @Test
    public void average_smaller_than_6_test(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> emptyNumbers = List.of();

        System.out.println("List 1..5 average: "
                + getAverageForElementsUnderLimit(numbers, 6));

        System.out.println("Empty list average: "
                + getAverageForElementsUnderLimit(emptyNumbers, 6));
    }

    private double getAverageForElementsUnderLimit(
            List<Integer> numbers,
            int limit) {
        // algorithm exception first
        // (fail fast / throw fast)
        if (numbers.size() == 0){
            return 0;
        }

        int count = 0;
        int sum = 0;

        for(int number : numbers){
            if(number < limit){
                sum += number;
                count++;
            }
        }

        return (double)sum / count;
    }

    @Test
    public void map_list_test(){
        List<Integer> numbers = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // task: get a list of duplicates from the numbers list
        // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]

        /*for(int number : numbers){
            System.out.print(number * 2 + " ");
        }*/

        List<String> duplicates = new ArrayList<>();
        for(int number : numbers){
            duplicates.add("" + number * 2);
        }

        System.out.println("Duplicates size: " + duplicates.size());
        System.out.println(duplicates);
    }

}
