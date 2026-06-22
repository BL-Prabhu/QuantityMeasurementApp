package service;


import model.LengthUnit;
import model.QuantityLength;

public interface QuantityService {

    double convert(double value, LengthUnit from, LengthUnit to);

    QuantityLength convert(QuantityLength quantity, LengthUnit to);

    boolean compare(QuantityLength q1, QuantityLength q2);
}