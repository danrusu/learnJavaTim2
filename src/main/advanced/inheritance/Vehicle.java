package main.advanced.inheritance;

public class Vehicle {

    private String name;
    protected int seatCapacity;
    public String color;
    float maxSpeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info(){
        System.out.println("This is a vehicle.");
    }

    public Vehicle(String name, int seatCapacity, String color, float maxSpeed) {

        this.name = name;
        this.seatCapacity = seatCapacity;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public static void printSeparator(){
        System.out.println("--------------------");
    }

    @Override
    public String toString() {
        return String.join(" | ",
                "VEHICLE",
                name,
                seatCapacity + " seats",
                color,
                maxSpeed + " km/h");
    }
}
