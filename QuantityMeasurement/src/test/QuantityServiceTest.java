package test;



import model.LengthUnit;
import model.QuantityLength;
import org.junit.Test;
import service.QuantityService;
import service.QuantityServiceImpl;

import static org.junit.Assert.*;

public class QuantityServiceTest {

    private final QuantityService service = new QuantityServiceImpl();

    @Test
    public void testFeetToFeet_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(service.areEqual(q1, q2));
    }

    @Test
    public void testInchToInch_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);

        assertTrue(service.areEqual(q1, q2));
    }

    @Test
    public void testFeetToInch_Equivalent() {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(service.areEqual(feet, inch));
    }

    @Test
    public void testDifferentValues() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);

        assertFalse(service.areEqual(q1, q2));
    }

    @Test
    public void testNullCheck() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);

        assertFalse(service.areEqual(q1, null));
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(1.0, null)
        );
    }
}