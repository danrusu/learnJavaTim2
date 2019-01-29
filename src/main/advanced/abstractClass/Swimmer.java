package main.advanced.abstractClass;

public interface Swimmer {

    public default void swim(){
        System.out.println("swimming");
    }
}
