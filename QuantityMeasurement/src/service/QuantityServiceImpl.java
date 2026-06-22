package service;

import model.LengthUnit;
import model.QuantityLength;

public class QuantityServiceImpl implements QuantityService {


    @Override
    public QuantityLength add(QuantityLength first, QuantityLength second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException("Operands cannot be null");
        }

        double totalFeet = first.toFeet() + second.toFeet();

        double resultValue =
                totalFeet / first.getUnit().getConversionFactor();

        return new QuantityLength(resultValue, first.getUnit());
    }

    @Override
    public QuantityLength addWithTargetUnit(
            QuantityLength first,
            QuantityLength second,
            LengthUnit targetUnit
    ) {

        if (first == null || second == null) {
            throw new IllegalArgumentException("Operands cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double totalFeet = first.toFeet() + second.toFeet();

        double result =
                totalFeet / targetUnit.getConversionFactor();

        return new QuantityLength(result, targetUnit);
    }


}
