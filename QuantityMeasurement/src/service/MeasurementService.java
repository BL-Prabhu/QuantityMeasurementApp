package service;

import model.Feet;

public class MeasurementService {

    // Business logic
    public boolean areEqual(Feet f1, Feet f2) {
        return f1.equals(f2);
    }
}