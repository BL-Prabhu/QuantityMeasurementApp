package quantitymeasurement;

import controller.MeasurementController;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        MeasurementController controller = new MeasurementController();

        controller.compareInches(1.0, 1.0);
        System.out.println();

        controller.compareFeet(1.0, 1.0);
    }
}