package controller;

import model.LengthUnit;
import model.QuantityLength;
import service.QuantityService;
import service.QuantityServiceImpl;

public class QuantityController {


    private final QuantityService service = new QuantityServiceImpl();

    public QuantityLength addLengths(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2
    ) {
        QuantityLength q1 = new QuantityLength(value1, unit1);
        QuantityLength q2 = new QuantityLength(value2, unit2);

        return service.add(q1, q2);
    }

    public QuantityLength addLengthsWithTarget(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2,
            LengthUnit targetUnit
    ) {
        QuantityLength q1 = new QuantityLength(value1, unit1);
        QuantityLength q2 = new QuantityLength(value2, unit2);

        return service.addWithTargetUnit(q1, q2, targetUnit);
    }

    public static void main(String[] args) {

        QuantityController controller = new QuantityController();

        System.out.println(
                controller.addLengths(1, LengthUnit.FEET, 12, LengthUnit.INCHES)
        );

        System.out.println(
                controller.addLengthsWithTarget(
                        1, LengthUnit.YARDS,
                        3, LengthUnit.FEET,
                        LengthUnit.YARDS
                )
        );
    }


}
