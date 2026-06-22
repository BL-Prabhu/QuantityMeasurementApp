package test;

import model.LengthUnit;
import model.QuantityLength;
import service.QuantityService;
import service.QuantityServiceImpl;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuantityServiceTest {


    private final QuantityService service = new QuantityServiceImpl();
    private static final double EPSILON = 0.0001;

    @Test
    public void testFeetPlusFeet() {
        QuantityLength result = service.add(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(2, LengthUnit.FEET)
        );

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    public void testFeetPlusInches() {
        QuantityLength result = service.add(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(12, LengthUnit.INCHES)
        );

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    public void testYardPlusFeet_TargetYard() {
        QuantityLength result = service.addWithTargetUnit(
                new QuantityLength(1, LengthUnit.YARDS),
                new QuantityLength(3, LengthUnit.FEET),
                LengthUnit.YARDS
        );

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        service.add(null, new QuantityLength(1, LengthUnit.FEET));
    }

    @Test
    public void testNegativeValues() {
        QuantityLength result = service.add(
                new QuantityLength(5, LengthUnit.FEET),
                new QuantityLength(-2, LengthUnit.FEET)
        );

        assertEquals(3.0, result.getValue(), EPSILON);
    }

}
