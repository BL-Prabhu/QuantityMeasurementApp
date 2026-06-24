package model;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS,
    FAHRENHEIT;

    @Override
    public double getConversionFactor() {
        return 1; // Not used
    }

    @Override
    public double convertToBaseUnit(double value) {
        if (this == FAHRENHEIT) {
            return (value - 32) * 5 / 9;
        }
        return value;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        if (this == FAHRENHEIT) {
            return (baseValue * 9 / 5) + 32;
        }
        return baseValue;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}