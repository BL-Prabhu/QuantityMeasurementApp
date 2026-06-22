package model;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARD(3.0),
    CM(1.0 / 30.48);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Convert given value to base unit (Feet)
    public double toBase(double value) {
        return value * conversionFactor;
    }

    // Convert from base (Feet) to target unit
    public double fromBase(double baseValue) {
        return baseValue / conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}