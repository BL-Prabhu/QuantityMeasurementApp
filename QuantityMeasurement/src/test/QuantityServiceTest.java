package test;


import model.LengthUnit;
import model.QuantityLength;
import org.junit.Test;
import service.QuantityService;
import service.QuantityServiceImpl;

import static org.junit.Assert.*;

public class QuantityServiceTest {

    private final QuantityService service = new QuantityServiceImpl();
    private static final double EPSILON = 0.0001;

    @Test
    public void testFeetToInches() {
        assertEquals(12.0,
                service.convert(1, LengthUnit.FEET, LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    public void testInchesToFeet() {
        assertEquals(2.0,
                service.convert(24, LengthUnit.INCHES, LengthUnit.FEET),
                EPSILON);
    }

    @Test
    public void testYardToFeet() {
        assertEquals(3.0,
                service.convert(1, LengthUnit.YARDS, LengthUnit.FEET),
                EPSILON);
    }

    @Test
    public void testCmToInches() {
        assertEquals(0.393701,
                service.convert(1, LengthUnit.CENTIMETERS, LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    public void testObjectConversion() {
        QuantityLength q = new QuantityLength(36, LengthUnit.INCHES);
        QuantityLength result = service.convert(q, LengthUnit.YARDS);

        assertTrue(result.isEqual(new QuantityLength(1, LengthUnit.YARDS)));
    }

    @Test
    public void testRoundTrip() {
        double val = service.convert(5, LengthUnit.FEET, LengthUnit.INCHES);
        double result = service.convert(val, LengthUnit.INCHES, LengthUnit.FEET);

        assertEquals(5.0, result, EPSILON);
    }

    @Test
    public void testNegative() {
        assertEquals(-12.0,
                service.convert(-1, LengthUnit.FEET, LengthUnit.INCHES),
                EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidUnit() {
        service.convert(1, null, LengthUnit.FEET);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidValue() {
        service.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES);
    }
}