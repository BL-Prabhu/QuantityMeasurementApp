package test;


import model.LengthUnit;
import model.Quantity;
import org.junit.Test;
import service.QuantityService;
import service.QuantityServiceImpl;

import static org.junit.Assert.*;

public class QuantityServiceTest {

    private final QuantityService<LengthUnit> service =
            new QuantityServiceImpl<>();

    private static final double EPSILON = 0.0001;

    @Test
    public void testSubtraction() {

        Quantity<LengthUnit> result =
                service.subtract(
                        new Quantity<>(10, LengthUnit.FEET),
                        new Quantity<>(6, LengthUnit.INCHES),
                        LengthUnit.FEET
                );

        assertEquals(9.5, result.getValue(), EPSILON);
    }

    @Test
    public void testDivision() {

        double result =
                service.divide(
                        new Quantity<>(10, LengthUnit.FEET),
                        new Quantity<>(2, LengthUnit.FEET)
                );

        assertEquals(5.0, result, EPSILON);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {

        service.divide(
                new Quantity<>(10, LengthUnit.FEET),
                new Quantity<>(0, LengthUnit.FEET)
        );
    }
}