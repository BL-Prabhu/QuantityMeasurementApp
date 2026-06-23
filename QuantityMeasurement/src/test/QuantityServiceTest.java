package test;

import model.Quantity;
import model.VolumeUnit;
import org.junit.Test;
import service.QuantityService;
import service.QuantityServiceImpl;

import static org.junit.Assert.*;

public class QuantityServiceTest {

    private final QuantityService service =
            new QuantityServiceImpl();

    private static final double EPSILON = 0.01;

    @Test
    public void testEquality() {

        assertTrue(
                service.equals(
                        new Quantity<>(1.0, VolumeUnit.LITRE),
                        new Quantity<>(1000.0, VolumeUnit.MILLILITRE)
                )
        );
    }

    @Test
    public void testConversion() {

        Quantity<VolumeUnit> result =
                service.convert(
                        new Quantity<>(1.0, VolumeUnit.LITRE),
                        VolumeUnit.MILLILITRE
                );

        assertEquals(1000.0, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition() {

        Quantity<VolumeUnit> result =
                service.add(
                        new Quantity<>(1.0, VolumeUnit.LITRE),
                        new Quantity<>(1000.0, VolumeUnit.MILLILITRE),
                        VolumeUnit.LITRE
                );

        assertEquals(2.0, result.getValue(), EPSILON);
    }
}