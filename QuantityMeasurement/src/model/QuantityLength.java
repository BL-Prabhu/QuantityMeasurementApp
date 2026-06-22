package model;

import java.util.Objects;

public final class QuantityLength {

    private static final double EPSILON = 0.0001;

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }

        this.unit = Objects.requireNonNull(unit, "Unit cannot be null");
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert current value to base unit (Feet)
    public double toFeet() {
        return value * unit.getConversionFactor();
    }

    // Convert to another unit
    public QuantityLength convertTo(LengthUnit targetUnit) {

        Objects.requireNonNull(targetUnit, "Target unit cannot be null");

        double baseValue = this.toFeet();
        double convertedValue =
                baseValue / targetUnit.getConversionFactor();

        return new QuantityLength(convertedValue, targetUnit);
    }

    // Equality check (based on base unit)
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        return Math.abs(this.toFeet() - other.toFeet()) < EPSILON;
    }

    // MUST override when equals is overridden
    @Override
    public int hashCode() {
        return Double.hashCode(toFeet());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}