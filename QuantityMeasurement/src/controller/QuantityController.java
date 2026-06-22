package controller;


import model.LengthUnit;
import model.QuantityLength;
import service.QuantityService;
import service.QuantityServiceImpl;

public class QuantityController {

    private final QuantityService service = new QuantityServiceImpl();

    public void runDemo() {

        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCH);

        boolean result1 = service.areEqual(feet, inches);

        System.out.println("1 ft == 12 inch ? " + result1);

        QuantityLength inch1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength inch2 = new QuantityLength(1.0, LengthUnit.INCH);

        boolean result2 = service.areEqual(inch1, inch2);

        System.out.println("1 inch == 1 inch ? " + result2);
    }

    public static void main(String[] args) {
        new QuantityController().runDemo();
    }
}