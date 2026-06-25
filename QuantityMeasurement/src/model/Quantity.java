package model;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // 🔹 Convert to base
    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    // 🔹 Convert to target unit
    public double convertTo(U targetUnit) {
        double baseValue = unit.convertToBaseUnit(this.value);
        return targetUnit.convertFromBaseUnit(baseValue);
    }
    public Quantity<U> to(U targetUnit) {
        double baseValue = unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new Quantity<>(convertedValue, targetUnit);
    }

    // ✅ ADD (same unit return)
    public Quantity<U> add(Quantity<U> other) {
        unit.validateOperationSupport("Addition");

        double resultBase = this.toBase() + other.toBase();
        double result = unit.convertFromBaseUnit(resultBase);

        return new Quantity<>(result, unit);
    }

    // ✅ ADD (target unit)
    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        unit.validateOperationSupport("Addition");

        double resultBase = this.toBase() + other.toBase();
        double result = targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(result, targetUnit);
    }

    // ✅ SUBTRACT
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        unit.validateOperationSupport("Subtraction");

        double resultBase = this.toBase() - other.toBase();
        double result = targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(result, targetUnit);
    }

    // ✅ DIVIDE
    public double divide(Quantity<U> other) {
        unit.validateOperationSupport("Division");

        return this.toBase() / other.toBase();
    }

    // ✅ EQUALS (IMPORTANT)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        return Math.abs(this.toBase() - other.toBase()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBase());
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}