package model;

public class Quantity {

    private static final double EPSILON = 0.0001;

    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {

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

    public LengthUnit getUnit() {
        return unit;
    }

    public Quantity convertTo(LengthUnit targetUnit) {

        double base = unit.toBase(value);
        double result = targetUnit.fromBase(base);

        return new Quantity(result, targetUnit);
    }

    public Quantity add(Quantity other, LengthUnit targetUnit) {

        double base1 = unit.toBase(value);
        double base2 = other.unit.toBase(other.value);

        double sum = base1 + base2;

        double result = targetUnit.fromBase(sum);

        return new Quantity(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Quantity)) return false;

        Quantity other = (Quantity) obj;

        double base1 = unit.toBase(value);
        double base2 = other.unit.toBase(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }
}