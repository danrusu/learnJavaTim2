package main.advanced.abstractClass;

public class AnimalDemo {


    public static void main(String[] args) {

        Animal animal = new Dog(); // Dog is a concrete class
        animal.drink();

        // Animal is an abstract class
        Animal dog = new Animal() {
            // implementation of the abstract class (anonymous class)
            @Override
            public void drink() {
                System.out.println("Animal drinking");
            }
        };
        dog.name = "Azurel";
        dog.drink();
        System.out.println(dog.name);

        //Swimmer fish = System.out::println;
        Swimmer fish = new Swimmer() {
            // implementation of the Swimmer interface (anonymous class)
            @Override
            public void swim() {
                System.out.println("swimming fast");
            }
        };
        fish.swim();
    }

}
