package main.advanced.threads;

public interface RunnableAndClonable extends Runnable, Cloneable {

    public static void main(String[] args) {
        RunnableAndClonable runnableAndClonable = () -> System.out.println("message");

    }

}