package test;

import model.LengthUnit;
import model.Quantity;
import org.junit.Test;
import service.QuantityService;
import service.QuantityServiceImpl;

import static org.junit.Assert.*;

public class QuantityServiceTest {

    private static final double EPSILON = 0.0001;

    private final QuantityService service =
            new QuantityServiceImpl();

    @Test
    public void testConvert_FeetToInches() {

        Quantity q = new Quantity(1, LengthUnit.FEET);

        Quantity result = service.convert(q, LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), EPSILON);
    }

    @Test
    public void testAdd_FeetAndInches() {

        Quantity q1 = new Quantity(1, LengthUnit.FEET);
        Quantity q2 = new Quantity(12, LengthUnit.INCHES);

        Quantity result =
                service.add(q1, q2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    public void testEquality() {

        Quantity q1 = new Quantity(36, LengthUnit.INCHES);
        Quantity q2 = new Quantity(1, LengthUnit.YARD);

        assertTrue(q1.equals(q2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidValue() {
        new Quantity(Double.NaN, LengthUnit.FEET);
    }
}