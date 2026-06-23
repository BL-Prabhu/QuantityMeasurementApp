package controller;

import model.LengthUnit;
import model.Quantity;
import service.QuantityService;
import service.QuantityServiceImpl;

public class QuantityController {

    private final QuantityService service = new QuantityServiceImpl();

    public Quantity convert(double value, LengthUnit from, LengthUnit to) {

        Quantity quantity = new Quantity(value, from);
        return service.convert(quantity, to);
    }

    public Quantity add(double v1, LengthUnit u1,
                        double v2, LengthUnit u2,
                        LengthUnit target) {

        Quantity q1 = new Quantity(v1, u1);
        Quantity q2 = new Quantity(v2, u2);

        return service.add(q1, q2, target);
    }
}