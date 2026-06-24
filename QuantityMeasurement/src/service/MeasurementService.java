package service;

import model.Feet;
import model.Inches;

public class MeasurementService {

    public boolean compareFeet(Feet f1, Feet f2) {
        return f1.equals(f2);
    }

    public boolean compareInches(Inches i1, Inches i2) {
        return i1.equals(i2);
    }
}