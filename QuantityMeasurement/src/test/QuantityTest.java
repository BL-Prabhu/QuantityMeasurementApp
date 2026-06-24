package test;

import model.LengthUnit;
import model.Quantity;
import model.TemperatureUnit;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityTest {

    private static final double EPSILON = 0.01;

    // ✅ ADDITION
    @Test
    public void givenFeetAndInches_WhenAdded_ShouldReturnFeet() {
        Quantity<LengthUnit> result =
                new Quantity<>(10, LengthUnit.FEET)
                        .add(new Quantity<>(6, LengthUnit.INCHES));

        assertEquals(10.5, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // ✅ ADDITION WITH TARGET UNIT
    @Test
    public void givenFeetAndInches_WhenAddedInInches_ShouldReturnInches() {
        Quantity<LengthUnit> result =
                new Quantity<>(1, LengthUnit.FEET)
                        .add(new Quantity<>(6, LengthUnit.INCHES), LengthUnit.INCHES);

        assertEquals(18.0, result.getValue(), EPSILON);
    }

    // ✅ SUBTRACTION
    @Test
    public void givenFeetAndInches_WhenSubtracted_ShouldReturnFeet() {
        Quantity<LengthUnit> result =
                new Quantity<>(10, LengthUnit.FEET)
                        .subtract(new Quantity<>(6, LengthUnit.INCHES));

        assertEquals(9.5, result.getValue(), EPSILON);
    }

    // ✅ DIVISION
    @Test
    public void givenSameLength_WhenDivided_ShouldReturnRatio() {
        double result =
                new Quantity<>(24, LengthUnit.INCHES)
                        .divide(new Quantity<>(2, LengthUnit.FEET));

        assertEquals(1.0, result, EPSILON);
    }

    // ✅ CONVERSION
    @Test
    public void givenFeet_WhenConvertedToInches_ShouldReturnCorrectValue() {
        Quantity<LengthUnit> result =
                new Quantity<>(1, LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), EPSILON);
    }

    // ✅ EQUALITY
    @Test
    public void givenSameLengthDifferentUnits_ShouldBeEqual() {
        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12, LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    // ❌ INVALID UNIT OPERATION
    @Test(expected = IllegalArgumentException.class)
    public void givenDifferentMeasurementTypes_WhenAdded_ShouldThrowException() {
        Quantity<LengthUnit> length = new Quantity<>(1, LengthUnit.FEET);
        Quantity<TemperatureUnit> temp = new Quantity<>(10, TemperatureUnit.CELSIUS);

        // unsafe cast to simulate misuse
        length.add((Quantity) temp);
    }

    // ❌ TEMPERATURE ARITHMETIC NOT ALLOWED
    @Test
    public void givenTemperature_WhenAdded_ShouldThrowException() {

        try {
            new Quantity<>(100.0, TemperatureUnit.CELSIUS)
                    .add(new Quantity<>(50.0, TemperatureUnit.CELSIUS));

            fail("Expected exception not thrown");

        } catch (UnsupportedOperationException e) {
            assertTrue(e.getMessage().contains("Temperature"));
        }
    }
}