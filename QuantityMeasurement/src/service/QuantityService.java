package service;

import model.IMeasurable;
import model.Quantity;

public interface QuantityService {

    <U extends IMeasurable> Quantity<U> convert(
            Quantity<U> quantity,
            U targetUnit
    );

    <U extends IMeasurable> Quantity<U> add(
            Quantity<U> first,
            Quantity<U> second,
            U targetUnit
    );

    <U extends IMeasurable> boolean equals(
            Quantity<U> first,
            Quantity<U> second
    );
}