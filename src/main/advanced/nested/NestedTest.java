package main.advanced.nested;

public class NestedTest {

    public static void main(String[] args) {

        Nested.Car car = new Nested.Car(
                Nested.CarProducer.PORSCHE,
                "911",
                100000);

        Nested.CarProducer carProducer = Nested.CarProducer.AUDI;

        Nested.Plane plane = new Nested().new Plane(
                50l,
                "BOEING");
    }
}
