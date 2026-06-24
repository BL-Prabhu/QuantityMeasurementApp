package model;

public class Quantity<U extends IMeasurable> {

    private static final double EPSILON = 0.0001;

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // 🔹 SUBTRACTION
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        validate(other, targetUnit);

        double result =
                unit.convertToBaseUnit(value)
                        - other.unit.convertToBaseUnit(other.value);

        double converted =
                targetUnit.convertFromBaseUnit(result);

        return new Quantity<>(round(converted), targetUnit);
    }

    // 🔹 DIVISION
    public double divide(Quantity<U> other) {

        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }

        double divisor =
                other.unit.convertToBaseUnit(other.value);

        if (Math.abs(divisor) < EPSILON) {
            throw new ArithmeticException("Division by zero");
        }

        double dividend =
                unit.convertToBaseUnit(value);

        return dividend / divisor;
    }

    private void validate(Quantity<U> other, U targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}