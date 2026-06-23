package controller;


import model.IMeasurable;
import model.Quantity;
import service.QuantityService;
import service.QuantityServiceImpl;

public class QuantityController {

    private final QuantityService service =
            new QuantityServiceImpl();

    public <U extends IMeasurable> Quantity<U> convert(
            double value,
            U from,
            U to
    ) {
        Quantity<U> quantity =
                new Quantity<>(value, from);

        return service.convert(quantity, to);
    }

    public <U extends IMeasurable> Quantity<U> add(
            double v1, U u1,
            double v2, U u2,
            U target
    ) {
        Quantity<U> q1 =
                new Quantity<>(v1, u1);

        Quantity<U> q2 =
                new Quantity<>(v2, u2);

        return service.add(q1, q2, target);
    }

    public <U extends IMeasurable> boolean compare(
            double v1, U u1,
            double v2, U u2
    ) {
        Quantity<U> q1 =
                new Quantity<>(v1, u1);

        Quantity<U> q2 =
                new Quantity<>(v2, u2);

        return service.areEqual(q1, q2);
    }
}