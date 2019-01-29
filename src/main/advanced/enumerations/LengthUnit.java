package main.advanced.enumerations;

public enum LengthUnit {

    METER(1),
    KM(1000),
    CENTIMETER(0.1f),
    INCH(0.025f),
    FOOT(0.3f);

    private float conversionFactor;

    LengthUnit(float conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public float getConversionFactor() {
        return conversionFactor;
    }
}
