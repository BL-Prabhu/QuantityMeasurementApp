package model;

public class QuantityLength {

    private static final double EPSILON = 0.0001;

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        validate(value);

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    public double toFeet() {
        return unit.toFeet(value);
    }

    public QuantityLength convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double feet = toFeet();
        double converted = targetUnit.fromFeet(feet);

        return new QuantityLength(converted, targetUnit);
    }

    public static double convert(double value,
                                 LengthUnit source,
                                 LengthUnit target) {

        validate(value);

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double feet = source.toFeet(value);
        return target.fromFeet(feet);
    }

    private static void validate(double value) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
    }

    public boolean isEqual(QuantityLength other) {
        return Math.abs(this.toFeet() - other.toFeet()) < EPSILON;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}