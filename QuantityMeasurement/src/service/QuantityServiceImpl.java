package service;

import model.IMeasurable;
import model.Quantity;

import java.util.Collections;
import java.util.List;

public class QuantityServiceImpl implements QuantityService {

    @Override
    public <U extends IMeasurable> int compare(
            Quantity<U> q1,
            Quantity<U> q2
    ) {
        return q1.compareTo(q2);
    }

    @Override
    public <U extends IMeasurable> List<Quantity<U>> sort(
            List<Quantity<U>> quantities
    ) {

        if (quantities == null) {
            throw new IllegalArgumentException("List cannot be null");
        }

        Collections.sort(quantities);
        return quantities;
    }
}