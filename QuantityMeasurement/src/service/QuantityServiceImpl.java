package service;

import model.IMeasurable;
import model.Quantity;

public class QuantityServiceImpl<U extends IMeasurable>
        implements QuantityService<U> {

    @Override
    public Quantity<U> add(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        return q1.add(q2, targetUnit);
    }

    @Override
    public Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        return q1.subtract(q2, targetUnit);
    }

    @Override
    public double divide(Quantity<U> q1, Quantity<U> q2) {
        return q1.divide(q2);
    }

    @Override
    public Quantity<U> convert(Quantity<U> quantity, U targetUnit) {
        return quantity.convertTo(targetUnit);
    }
}