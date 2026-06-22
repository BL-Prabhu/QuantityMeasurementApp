package app;

import controller.MeasurementController;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        MeasurementController controller = new MeasurementController();

        controller.checkEquality(1.0, 1.0);
    }
}