package service;


import model.IMeasurable;
import model.Quantity;

import java.util.Objects;

public class QuantityServiceImpl implements QuantityService {

    @Override
    public <U extends IMeasurable> Quantity<U> convert(
            Quantity<U> quantity,
            U targetUnit
    ) {
        Objects.requireNonNull(quantity);
        Objects.requireNonNull(targetUnit);

        return quantity.convertTo(targetUnit);
    }

    @Override
    public <U extends IMeasurable> Quantity<U> add(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit
    ) {
        Objects.requireNonNull(q1);
        Objects.requireNonNull(q2);
        Objects.requireNonNull(targetUnit);

        return q1.add(q2, targetUnit);
    }

    @Override
    public <U extends IMeasurable> boolean areEqual(
            Quantity<U> q1,
            Quantity<U> q2
    ) {
        Objects.requireNonNull(q1);
        Objects.requireNonNull(q2);

        return q1.equals(q2);
    }
}