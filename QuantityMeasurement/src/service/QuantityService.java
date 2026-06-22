package service;

import model.LengthUnit;
import model.QuantityLength;

public interface QuantityService {

    QuantityLength add(
            QuantityLength first,
            QuantityLength second,
            LengthUnit targetUnit
    );
}