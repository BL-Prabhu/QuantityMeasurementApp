package test;

import model.QuantityWeight;
import model.WeightUnit;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityWeightTest {

    private static final double EPSILON = 0.0001;

    @Test
    public void testEquality() {
        assertEquals(
                new QuantityWeight(1, WeightUnit.KILOGRAM),
                new QuantityWeight(1000, WeightUnit.GRAM)
        );
    }

    @Test
    public void testConversion() {
        QuantityWeight result =
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(1000, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition() {
        QuantityWeight result =
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000, WeightUnit.GRAM));

        assertEquals(2.0, result.getValue(), EPSILON);
    }
}