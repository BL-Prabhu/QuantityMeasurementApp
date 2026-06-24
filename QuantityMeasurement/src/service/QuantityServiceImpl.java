package service;

import model.IMeasurable;
import model.Quantity;

public class QuantityServiceImpl<U extends IMeasurable> implements QuantityService<U> {

    @Override
    public Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2, U unit) {
        return q1.subtract(q2, unit);
    }

    @Override
    public double divide(Quantity<U> q1, Quantity<U> q2) {
        return q1.divide(q2);
    }
}