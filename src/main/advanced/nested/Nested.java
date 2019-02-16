package main.advanced.nested;

import java.util.function.Predicate;

public class Nested {

    public enum CarProducer {
        AUDI,
        PORSCHE,
        FORD,
        HONDA
    }

    public static class Car{
        private CarProducer carProducer;
        private double priceInEuro;
        private String modelName;

        public Car(CarProducer carProducer, String modelName, double priceInEuro) {
            this.carProducer = carProducer;
            this.priceInEuro = priceInEuro;
            this.modelName = modelName;
        }

        public CarProducer getCarProducer() {
            return carProducer;
        }

        public double getPriceInEuro() {
            return priceInEuro;
        }

        public String getModelName() {
            return modelName;
        }

        @Override
        public String toString() {
            return String.join(" | ",
                    carProducer.name(),
                    modelName,
                    priceInEuro + "");
        }

    }

    public class Plane{
        private Long sizeInMeters;
        private String modelName;

        public Plane(Long sizeInMeters, String modelName) {
            this.sizeInMeters = sizeInMeters;
            this.modelName = modelName;
        }

        public Long getSizeInMeters() {
            return sizeInMeters;
        }

        public String getModelName() {
            return modelName;
        }
    }

}
