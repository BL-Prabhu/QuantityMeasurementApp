package controller;
import model.LengthUnit;
import model.QuantityLength;
import service.QuantityService;
import service.QuantityServiceImpl;

public class QuantityController {

    private final QuantityService service = new QuantityServiceImpl();

    public void run() {

        // Method 1 (Primitive Conversion)
        System.out.println("1 ft to inch = " +
                service.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES));

        System.out.println("3 yard to feet = " +
                service.convert(3.0, LengthUnit.YARDS, LengthUnit.FEET));

        // Method 2 (Object Conversion)
        QuantityLength length = new QuantityLength(36, LengthUnit.INCHES);

        System.out.println("36 inches to yard = " +
                service.convert(length, LengthUnit.YARDS));

        // Equality
        QuantityLength yard = new QuantityLength(1, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(3, LengthUnit.FEET);

        System.out.println("1 yard == 3 feet ? " +
                service.compare(yard, feet));
    }

    public static void main(String[] args) {
        new QuantityController().run();
    }
}