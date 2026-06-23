package model;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARD(3.0),
    CENTIMETER(1.0 / 30.48);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    // ✅ ADD THIS METHOD (Required)
    public double getConversionFactor() {
        return factor;
    }

    public double toBase(double value) {
        validate(value);
        return value * factor;
    }

    public double fromBase(double baseValue) {
        validate(baseValue);
        return baseValue / factor;
    }

    private void validate(double value) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}