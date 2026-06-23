package model;

import java.util.Objects;

public class QuantityWeight {

    private static final double EPSILON = 0.0001;

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.unit = Objects.requireNonNull(unit);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public double toBase() {
        return unit.toBase(value);
    }

    public QuantityWeight convertTo(WeightUnit target) {
        double base = toBase();
        return new QuantityWeight(target.fromBase(base), target);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit target) {
        double totalBase = this.toBase() + other.toBase();
        return new QuantityWeight(target.fromBase(totalBase), target);
    }

    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityWeight)) return false;

        QuantityWeight other = (QuantityWeight) obj;

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