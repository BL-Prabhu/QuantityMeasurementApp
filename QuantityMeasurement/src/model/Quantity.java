package model;

public class Quantity<U extends IMeasurable>
        implements Comparable<Quantity<U>> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
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

    // 🔹 Comparison logic
    @Override
    public int compareTo(Quantity<U> other) {

        if (other == null) {
            throw new IllegalArgumentException("Cannot compare with null");
        }

        if (!unit.getClass().equals(other.unit.getClass())) {
            throw new IllegalArgumentException("Cross-category comparison not allowed");
        }

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        return Double.compare(thisBase, otherBase);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    // 🔹 Subtraction
    public Quantity<U> subtract(Quantity<U> other, U resultUnit) {

        if (other == null) {
            throw new IllegalArgumentException("Cannot subtract null");
        }

        if (!unit.getClass().equals(other.unit.getClass())) {
            throw new IllegalArgumentException("Cross-category not allowed");
        }

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double resultBase = thisBase - otherBase;

        double finalValue = resultUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(finalValue, resultUnit);
    }

    // 🔹 Division
    public double divide(Quantity<U> other) {

        if (other == null) {
            throw new IllegalArgumentException("Cannot divide by null");
        }

        if (!unit.getClass().equals(other.unit.getClass())) {
            throw new IllegalArgumentException("Cross-category not allowed");
        }

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        if (otherBase == 0) {
            throw new ArithmeticException("Division by zero");
        }

        return thisBase / otherBase;
    }
}