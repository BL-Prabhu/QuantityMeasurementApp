package controller;

import model.Feet;
import model.Inches;
import service.MeasurementService;

public class MeasurementController {

    private final MeasurementService service;

    public MeasurementController() {
        this.service = new MeasurementService();
    }

    public void compareFeet(double v1, double v2) {

        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);

        boolean result = service.compareFeet(f1, f2);

        System.out.println("Input: " + v1 + " ft and " + v2 + " ft");
        System.out.println("Output: " + (result ? "Equal (true)" : "Not Equal (false)"));
    }

    public void compareInches(double v1, double v2) {

        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);

        boolean result = service.compareInches(i1, i2);

        System.out.println("Input: " + v1 + " inch and " + v2 + " inch");
        System.out.println("Output: " + (result ? "Equal (true)" : "Not Equal (false)"));
    }
}