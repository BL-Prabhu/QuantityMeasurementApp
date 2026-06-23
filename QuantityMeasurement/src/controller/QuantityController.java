package controller;


import model.Quantity;
import model.VolumeUnit;
import service.QuantityService;
import service.QuantityServiceImpl;

public class QuantityController {

    private final QuantityService service =
            new QuantityServiceImpl();

    public void runVolumeDemo() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Equality: " +
                service.equals(litre, ml));

        System.out.println("Convert: " +
                service.convert(litre, VolumeUnit.MILLILITRE));

        System.out.println("Add: " +
                service.add(litre, ml, VolumeUnit.LITRE));
    }

    public static void main(String[] args) {
        new QuantityController().runVolumeDemo();
    }
}