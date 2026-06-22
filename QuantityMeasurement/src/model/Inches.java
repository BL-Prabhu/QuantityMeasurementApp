package model;

import java.util.Objects;

public class Inches {

    private final double value;

    public Inches(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Inches inches = (Inches) obj;

        return Double.compare(this.value, inches.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}