package service;

import model.IMeasurable;
import model.Quantity;

public class QuantityServiceImpl implements QuantityService {

    @Override
    public <U extends IMeasurable> Quantity<U> convert(
            Quantity<U> quantity,
            U targetUnit
    ) {
        return quantity.convertTo(targetUnit);
    }

    @Override
    public <U extends IMeasurable> Quantity<U> add(
            Quantity<U> first,
            Quantity<U> second,
            U targetUnit
    ) {
        return first.add(second, targetUnit);
    }

    @Override
    public <U extends IMeasurable> boolean equals(
            Quantity<U> first,
            Quantity<U> second
    ) {
        return first.equals(second);
    }
}