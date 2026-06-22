package controller;

import model.Feet;
import service.MeasurementService;

public class MeasurementController {

    private final MeasurementService service;

    public MeasurementController() {
        this.service = new MeasurementService();
    }

    public void checkEquality(double value1, double value2) {

        Feet f1 = new Feet(value1);
        Feet f2 = new Feet(value2);

        boolean result = service.areEqual(f1, f2);

        System.out.println("Input: " + value1 + " ft and " + value2 + " ft");

        if (result) {
            System.out.println("Output: Equal (true)");
        } else {
            System.out.println("Output: Not Equal (false)");
        }
    }
}