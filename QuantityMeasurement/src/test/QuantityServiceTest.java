package test;

import model.LengthUnit;
import model.Quantity;
import service.QuantityService;
import service.QuantityServiceImpl;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityServiceTest {

    private static final double EPSILON = 0.01;

    QuantityService<LengthUnit> service =
            new QuantityServiceImpl<>();

    @Test
    public void testAddUsingService() {
        Quantity<LengthUnit> result =
                service.add(
                        new Quantity<>(10, LengthUnit.FEET),
                        new Quantity<>(6, LengthUnit.INCHES),
                        LengthUnit.FEET
                );

        assertEquals(10.5, result.getValue(), EPSILON);
    }

    @Test
    public void testSubtractUsingService() {
        Quantity<LengthUnit> result =
                service.subtract(
                        new Quantity<>(10, LengthUnit.FEET),
                        new Quantity<>(6, LengthUnit.INCHES),
                        LengthUnit.FEET
                );

        assertEquals(9.5, result.getValue(), EPSILON);
    }

    @Test
    public void testDivideUsingService() {
        double result =
                service.divide(
                        new Quantity<>(24, LengthUnit.INCHES),
                        new Quantity<>(2, LengthUnit.FEET)
                );

        assertEquals(1.0, result, EPSILON);
    }

    @Test
    public void testConvertUsingService() {
        Quantity<LengthUnit> result =
                service.convert(
                        new Quantity<>(1, LengthUnit.FEET),
                        LengthUnit.INCHES
                );

        assertEquals(12.0, result.getValue(), EPSILON);
    }
}