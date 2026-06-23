package test;


import model.LengthUnit;
import model.Quantity;
import model.WeightUnit;
import org.junit.Test;
import service.QuantityService;
import service.QuantityServiceImpl;

import static org.junit.Assert.*;

public class QuantityServiceTest {

    private static final double EPSILON = 0.0001;

    private final QuantityService service =
            new QuantityServiceImpl();

    @Test
    public void testLengthConversion() {

        Quantity<LengthUnit> result =
                service.convert(
                        new Quantity<>(1, LengthUnit.FEET),
                        LengthUnit.INCHES
                );

        assertEquals(12.0, result.getValue(), EPSILON);
    }

    @Test
    public void testWeightConversion() {

        Quantity<WeightUnit> result =
                service.convert(
                        new Quantity<>(1, WeightUnit.KILOGRAM),
                        WeightUnit.GRAM
                );

        assertEquals(1000.0, result.getValue(), EPSILON);
    }

    @Test
    public void testLengthAddition() {

        Quantity<LengthUnit> result =
                service.add(
                        new Quantity<>(1, LengthUnit.FEET),
                        new Quantity<>(12, LengthUnit.INCHES),
                        LengthUnit.FEET
                );

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    public void testWeightAddition() {

        Quantity<WeightUnit> result =
                service.add(
                        new Quantity<>(1, WeightUnit.KILOGRAM),
                        new Quantity<>(1000, WeightUnit.GRAM),
                        WeightUnit.KILOGRAM
                );

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    public void testEquality() {

        assertTrue(
                service.areEqual(
                        new Quantity<>(1, LengthUnit.FEET),
                        new Quantity<>(12, LengthUnit.INCHES)
                )
        );
    }

    @Test
    public void testCrossTypeComparison() {

        assertFalse(
                new Quantity<>(1, LengthUnit.FEET)
                        .equals(
                                new Quantity<>(1, WeightUnit.KILOGRAM)
                        )
        );
    }
}