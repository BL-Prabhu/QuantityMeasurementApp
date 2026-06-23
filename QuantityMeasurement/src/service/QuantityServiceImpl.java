package service;

import model.LengthUnit;
import model.Quantity;

public class QuantityServiceImpl implements QuantityService {

    @Override
    public Quantity convert(Quantity quantity, LengthUnit targetUnit) {

        if (quantity == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        return quantity.convertTo(targetUnit);
    }

    @Override
    public Quantity add(Quantity q1, Quantity q2, LengthUnit targetUnit) {

        if (q1 == null || q2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        return q1.add(q2, targetUnit);
    }
}