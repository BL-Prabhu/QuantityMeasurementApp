package service;


import model.QuantityLength;

public class QuantityServiceImpl implements QuantityService {

    @Override
    public boolean compare(QuantityLength q1, QuantityLength q2) {

        if (q1 == null || q2 == null) {
            return false;
        }

        return q1.isEqual(q2);
    }
}