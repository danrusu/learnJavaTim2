package main.advanced.enumerations;

public enum LengthUnitClassic {

    METER,
    KM, // uncomment to throw on default case
    CENTIMETER,
    INCH,
    FOOT;

    public float getConversionFactor() throws Exception {

        switch (this){
            case INCH: return 0.025f;
            case CENTIMETER: return 0.1f;
            case FOOT: return 0.3f;
            case METER: return 1;
            //case KM: return 1000;

            default: throw new Exception("No conversion factor defined for " + this);
        }
    }
}
