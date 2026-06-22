package controller;

import model.LengthUnit;
import model.Quantity;
import service.QuantityService;
import service.QuantityServiceImpl;

public class QuantityController {

    public static void main(String[] args) {

        QuantityService service = new QuantityServiceImpl();

        // Convert
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity converted = service.convert(q1, LengthUnit.INCHES);

        System.out.println("Convert 1 FEET to INCHES: " + converted.getValue());

        // Add
        Quantity q2 = new Quantity(12.0, LengthUnit.INCHES);
        Quantity result = service.add(q1, q2, LengthUnit.FEET);

        System.out.println("Add 1 FEET + 12 INCHES in FEET: " + result.getValue());

        // Equality
        Quantity q3 = new Quantity(36.0, LengthUnit.INCHES);
        Quantity q4 = new Quantity(1.0, LengthUnit.YARD);

        System.out.println("36 INCHES == 1 YARD: " + q3.equals(q4));
    }
}