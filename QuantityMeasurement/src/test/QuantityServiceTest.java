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
    public void testFeetTarget() {

        QuantityLength result = service.add(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(12, LengthUnit.INCHES),
                LengthUnit.FEET
        );

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    public void testInchesTarget() {

        QuantityLength result = service.add(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(12, LengthUnit.INCHES),
                LengthUnit.INCHES
        );

        assertEquals(24.0, result.getValue(), EPSILON);
    }

    @Test
    public void testYardsTarget() {

        QuantityLength result = service.add(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(12, LengthUnit.INCHES),
                LengthUnit.YARDS
        );

        assertEquals(0.6667, result.getValue(), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullTargetUnit() {

        service.add(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(12, LengthUnit.INCHES),
                null
        );
    }

    @Test
    public void testNegativeValues() {

        QuantityLength result = service.add(
                new QuantityLength(5, LengthUnit.FEET),
                new QuantityLength(-2, LengthUnit.FEET),
                LengthUnit.INCHES
        );

        assertEquals(36.0, result.getValue(), EPSILON);
    }
}