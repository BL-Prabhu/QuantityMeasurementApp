package test;

import model.LengthUnit;
import model.Quantity;
import model.TemperatureUnit; // ✅ FIX: missing import

import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityServiceTest {

    private static final double EPSILON = 0.01;

    @Test
    public void testAddition() {
        Quantity<LengthUnit> result =
                new Quantity<>(10, LengthUnit.FEET)
                        .add(new Quantity<>(6, LengthUnit.INCHES));

        assertEquals(10.5, result.getValue(), EPSILON);
    }

    @Test
    public void testSubtraction() {
        Quantity<LengthUnit> result =
                new Quantity<>(10, LengthUnit.FEET)
                        .subtract(new Quantity<>(6, LengthUnit.INCHES));

        assertEquals(9.5, result.getValue(), EPSILON);
    }

    @Test
    public void testDivision() {
        double result =
                new Quantity<>(24, LengthUnit.INCHES)
                        .divide(new Quantity<>(2, LengthUnit.FEET));

        assertEquals(1.0, result, EPSILON);
    }

    @Test
    public void testTemperatureNotSupportingArithmetic() {

        try {
            new Quantity<>(100.0, TemperatureUnit.CELSIUS)
                    .add(new Quantity<>(50.0, TemperatureUnit.CELSIUS));

            fail("Expected exception not thrown"); // ✅ better practice

        } catch (UnsupportedOperationException e) { // ✅ specific exception
            assertTrue(e.getMessage().contains("Temperature"));
        }
    }


}