package model;

public enum LengthUnit implements IMeasurable {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    @Override
    public double getConversionFactor() {
        return factor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * factor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factor;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}