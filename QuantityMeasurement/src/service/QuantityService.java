package service;


import model.IMeasurable;
import model.Quantity;

public interface QuantityService {

    <U extends IMeasurable> Quantity<U> convert(
            Quantity<U> quantity,
            U targetUnit
    );

    <U extends IMeasurable> Quantity<U> add(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit
    );

    <U extends IMeasurable> boolean areEqual(
            Quantity<U> q1,
            Quantity<U> q2
    );
}