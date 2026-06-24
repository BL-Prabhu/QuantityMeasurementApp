package model;

public class Quantity<U extends IMeasurable> {

    private double value;
    private U unit;

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

    private void validateArithmetic(Quantity<U> other) {

        if (!unit.getClass().equals(other.unit.getClass())) {
            throw new IllegalArgumentException("Incompatible units");
        }

        // ❗ BLOCK TEMPERATURE
        if (unit.getClass().getSimpleName().equals("TemperatureUnit")) {
            throw new UnsupportedOperationException("Temperature arithmetic not supported");
        }
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        validateArithmetic(other);

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 + base2;

        double finalValue = targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(finalValue, targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        validateArithmetic(other);

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 - base2;

        double finalValue = targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(finalValue, targetUnit);
    }

    public double divide(Quantity<U> other) {

        validateArithmetic(other);

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return base1 / base2;
    }

    public Quantity<U> convertTo(U targetUnit) {

        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(converted, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Quantity<?> other = (Quantity<?>) obj;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < 0.01;
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }
}