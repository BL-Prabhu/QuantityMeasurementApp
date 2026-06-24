package controller;

import model.LengthUnit;
import model.Quantity;
import service.QuantityService;
import service.QuantityServiceImpl;

import java.util.Arrays;
import java.util.List;

public class QuantityController {

    public static void main(String[] args) {

        QuantityService service = new QuantityServiceImpl();

        Quantity<LengthUnit> q1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        // ✅ Comparison
        int result = service.compare(q1, q2);

        System.out.println("Comparison Result: " + result);

        // ✅ Sorting
        List<Quantity<LengthUnit>> list = Arrays.asList(
                new Quantity<>(3.0, LengthUnit.FEET),
                new Quantity<>(24.0, LengthUnit.INCHES),
                new Quantity<>(1.0, LengthUnit.YARDS)
        );

        List<Quantity<LengthUnit>> sorted = service.sort(list);

        System.out.println("\nSorted Quantities (Base Unit - FEET):");

        sorted.forEach(q -> {
            double base = q.getUnit().convertToBaseUnit(q.getValue());
            System.out.println(base + " FEET");
        });
    }
}