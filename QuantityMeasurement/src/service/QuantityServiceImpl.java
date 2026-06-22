package service;


import model.LengthUnit;
import model.QuantityLength;

public class QuantityServiceImpl implements QuantityService {

    @Override
    public double convert(double value, LengthUnit from, LengthUnit to) {
        return QuantityLength.convert(value, from, to);
    }

    @Override
    public QuantityLength convert(QuantityLength quantity, LengthUnit to) {

        if (quantity == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        return quantity.convertTo(to);
    }

    @Override
    public boolean compare(QuantityLength q1, QuantityLength q2) {

        if (q1 == null || q2 == null) {
            return false;
        }

        return q1.isEqual(q2);
    }
}