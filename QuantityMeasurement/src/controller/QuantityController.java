package controller;


import model.LengthUnit;
import model.Quantity;
import service.QuantityService;
import service.QuantityServiceImpl;

public class QuantityController {

    public static void main(String[] args) {

        QuantityService<LengthUnit> service =
                new QuantityServiceImpl<>();

        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(6.0, LengthUnit.INCHES);

        // SUBTRACTION
        Quantity<LengthUnit> result =
                service.subtract(q1, q2, LengthUnit.FEET);

        System.out.println("Subtraction Result: " + result.getValue());

        // DIVISION
        double division =
                service.divide(q1, q2);

        System.out.println("Division Result: " + division);
    }
}