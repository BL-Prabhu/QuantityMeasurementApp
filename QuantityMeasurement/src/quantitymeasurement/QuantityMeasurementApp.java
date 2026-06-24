package quantitymeasurement;

import model.LengthUnit;
import model.Quantity;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6, LengthUnit.INCHES);

// Subtraction
        System.out.println(
                "Subtraction: " + q1.subtract(q2, LengthUnit.FEET).getValue()
        );

// Division
        System.out.println(
                "Division: " + q1.divide(q2)
        );
    }
}