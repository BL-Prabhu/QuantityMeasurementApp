package service;

import model.LengthUnit;
import model.Quantity;

public interface QuantityService {

    Quantity convert(Quantity quantity, LengthUnit targetUnit);

    Quantity add(Quantity q1, Quantity q2, LengthUnit targetUnit);
}