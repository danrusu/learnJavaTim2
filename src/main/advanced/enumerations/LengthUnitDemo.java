package main.advanced.enumerations;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LengthUnitDemo {

    public float convertToMeter(float length, LengthUnitClassic lengthUnit) throws Exception {

        float conversionFactor = lengthUnit.getConversionFactor();
        return length * conversionFactor;
    }

    public float convertToMeter(float length, LengthUnit lengthUnit) {

        float conversionFactor = lengthUnit.getConversionFactor();
        return length * conversionFactor;
    }

    @Test
    public void enums_print_test() throws Exception {

        System.out.println(LengthUnitClassic.METER); // implicit toString
        System.out.println(LengthUnitClassic.METER.toString());
        System.out.println(LengthUnitClassic.METER.name());

        System.out.println(LengthUnitClassic.METER.getClass().getName());
        System.out.println(LengthUnitClassic.INCH.getClass().getName());

        System.out.println(LengthUnitClassic.CENTIMETER);
        System.out.println(LengthUnitClassic.INCH);
        System.out.println(LengthUnitClassic.FOOT);


        final LengthUnitClassic[] allLengthUnits = LengthUnitClassic.values();
        System.out.println(Arrays.toString(allLengthUnits));

        for(LengthUnitClassic lengthUnit : allLengthUnits){
            System.out.println(lengthUnit);
        }

        String centimeter = "centimeter";
        LengthUnitClassic lUnit = LengthUnitClassic.valueOf(
                centimeter.toUpperCase());
        System.out.println("Centimeters unit: " + lUnit);

        LengthUnitClassic newUnit = LengthUnitClassic.METER;
        System.out.println(
                newUnit + " conversion factor " +
                newUnit.getConversionFactor());

    }

    @Test
    public void get_conversion_factor_test() throws Exception {

        final LengthUnitClassic[] allUnits = LengthUnitClassic.values();

        for (LengthUnitClassic lengthUnit : allUnits){
            System.out.println(lengthUnit
                    + " : "
                    + lengthUnit.getConversionFactor());
        }
    }


    @Test
    public void conversion_test() throws Exception {

        float lengthToConvert = 1;
        LengthUnit lengthUnitToConvert = LengthUnit.KM;

        float inchToMeter = convertToMeter(
                lengthToConvert,
                lengthUnitToConvert);

        System.out.println(
                lengthToConvert + " " + lengthUnitToConvert
        + " = " + inchToMeter + " METER");
    }
}
