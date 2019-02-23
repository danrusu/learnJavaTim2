package main.advanced.generics;

public class Box {

    private Object item;
    private Object item2;


    public Box(Object item, Object item2) {
        this.item = item;
        this.item2 = item2;
    }


    public Object getItem2() {
        return item2;
    }


    public Object getItem() {
        return item;
    }
}
