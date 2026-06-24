package service;

import model.IMeasurable;
import model.Quantity;

import java.util.List;

public interface QuantityService {

    <U extends IMeasurable> int compare(
            Quantity<U> q1,
            Quantity<U> q2
    );

    <U extends IMeasurable> List<Quantity<U>> sort(
            List<Quantity<U>> quantities
    );
}