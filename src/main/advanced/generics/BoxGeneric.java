package main.advanced.generics;

public class BoxGeneric <T, U> {

    private T item;
    private U item2;


    public BoxGeneric(T item, U item2) {
        this.item = item;
        this.item2 = item2;
    }


    public T getItem() {
        return item;
    }


    public U getItem2() {
        return item2;
    }
}
