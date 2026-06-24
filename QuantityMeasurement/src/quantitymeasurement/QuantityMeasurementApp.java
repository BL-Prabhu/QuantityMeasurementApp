package quantitymeasurement;

import model.LengthUnit;
import model.Quantity;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6, LengthUnit.INCHES);

        // Subtraction
        Quantity<LengthUnit> result =
                q1.subtract(q2, LengthUnit.FEET);

        System.out.println("Subtraction: " + result.getValue() + " FEET");

        // Division
        double division = q1.divide(q2);

        System.out.println("Division: " + division);
    }
}