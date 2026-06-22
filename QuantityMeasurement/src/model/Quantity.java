package model;

import java.util.Objects;

public final class Quantity {

    private static final double EPSILON = 0.0001;

    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
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

    public double toBase() {
        return unit.toBase(value);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;

        Quantity other = (Quantity) obj;

        return Math.abs(this.toBase() - other.toBase()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toBase());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}