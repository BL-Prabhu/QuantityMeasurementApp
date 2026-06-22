package test;

import model.Feet;
import service.MeasurementService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MeasurementTest {

    MeasurementService service = new MeasurementService();

    @Test
    void givenSameFeetValues_whenCompared_thenShouldReturnTrue() {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        assertTrue(service.areEqual(f1, f2));
    }

    @Test
    void givenDifferentFeetValues_whenCompared_thenShouldReturnFalse() {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(2.0);

        assertFalse(service.areEqual(f1, f2));
    }
}