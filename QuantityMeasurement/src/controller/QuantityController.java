package controller;


import model.LengthUnit;
import model.QuantityLength;
import service.QuantityService;
import service.QuantityServiceImpl;

public class QuantityController {

    private final QuantityService service = new QuantityServiceImpl();

    public void run() {

        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);

        System.out.println("1 Yard == 3 Feet : " + service.compare(yard, feet));

        QuantityLength inches = new QuantityLength(36.0, LengthUnit.INCHES);
        System.out.println("1 Yard == 36 Inches : " + service.compare(yard, inches));

        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength inch = new QuantityLength(0.393701, LengthUnit.INCHES);

        System.out.println("1 CM == 0.393701 Inches : " + service.compare(cm, inch));
    }

    public static void main(String[] args) {
        new QuantityController().run();
    }
}