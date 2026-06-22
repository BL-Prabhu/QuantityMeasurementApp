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
    public void testYardToFeet() {
        assertTrue(service.compare(
                new QuantityLength(1, LengthUnit.YARDS),
                new QuantityLength(3, LengthUnit.FEET)
        ));
    }

    @Test
    public void testYardToInches() {
        assertTrue(service.compare(
                new QuantityLength(1, LengthUnit.YARDS),
                new QuantityLength(36, LengthUnit.INCHES)
        ));
    }

    @Test
    public void testCmToInches() {
        assertTrue(service.compare(
                new QuantityLength(1, LengthUnit.CENTIMETERS),
                new QuantityLength(0.393701, LengthUnit.INCHES)
        ));
    }

    @Test
    public void testDifferentValues() {
        assertFalse(service.compare(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(2, LengthUnit.FEET)
        ));
    }

    @Test
    public void testNullHandling() {
        assertFalse(service.compare(null,
                new QuantityLength(1, LengthUnit.FEET)));
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(1, null)
        );
    }
}