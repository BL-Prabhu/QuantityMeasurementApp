package model;

import java.util.Objects;

public class Quantity<T extends IMeasurable> {

    private final double value;
    private final T unit;

    public Quantity(double value, T unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public T getUnit() {
        return unit;
    }

    // 🔥 COMMON VALIDATION
    private void validateArithmetic(Quantity<T> other) {

        if (!unit.getClass().equals(other.unit.getClass())) {
            throw new IllegalArgumentException("Incompatible units");
        }

        // 🚫 Temperature restriction
        if (unit instanceof TemperatureUnit) {
            throw new UnsupportedOperationException(
                    "Temperature does not support arithmetic operations"
            );
        }
    }

    // ✅ ADD
    public Quantity<T> add(Quantity<T> other) {
        validateArithmetic(other);

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 + base2;

        double finalValue = unit.convertFromBaseUnit(resultBase);

        return new Quantity<>(finalValue, unit);
    }

    // ✅ ADD with target unit
    public Quantity<T> add(Quantity<T> other, T targetUnit) {
        validateArithmetic(other);

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 + base2;

        double finalValue = targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(finalValue, targetUnit);
    }

    // ✅ SUBTRACT
    public Quantity<T> subtract(Quantity<T> other) {
        return subtract(other, unit);
    }

    // ✅ SUBTRACT with target unit
    public Quantity<T> subtract(Quantity<T> other, T targetUnit) {
        validateArithmetic(other);

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 - base2;

        double finalValue = targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(finalValue, targetUnit);
    }

    // ✅ DIVIDE
    public double divide(Quantity<T> other) {

        if (!unit.getClass().equals(other.unit.getClass())) {
            throw new IllegalArgumentException("Incompatible units");
        }

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return base1 / base2;
    }

    // ✅ CONVERT
    public Quantity<T> convertTo(T targetUnit) {

        if (!unit.getClass().equals(targetUnit.getClass())) {
            throw new IllegalArgumentException("Incompatible units");
        }

        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(converted, targetUnit);
    }

    // ✅ EQUALITY
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Quantity<?> other)) return false;

        // ❌ Different measurement types
        if (!unit.getClass().equals(other.unit.getClass())) {
            return false;
        }

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < 0.01;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit.getClass(), unit.convertToBaseUnit(value));
    }
}