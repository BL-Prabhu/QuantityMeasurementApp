package service;

import model.IMeasurable;
import model.Quantity;

public interface QuantityService<U extends IMeasurable> {

    Quantity<U> add(Quantity<U> q1, Quantity<U> q2, U targetUnit);

    Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2, U targetUnit);

    double divide(Quantity<U> q1, Quantity<U> q2);

    Quantity<U> convert(Quantity<U> quantity, U targetUnit);
}