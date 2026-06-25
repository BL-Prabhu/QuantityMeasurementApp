package test;

import dto.QuantityDTO;
import entity.QuantityMeasurementEntity;
import org.junit.Test;
import repository.IQuantityMeasurementRepository;
import service.QuantityMeasurementServiceImpl;

import static org.junit.Assert.*;

public class QuantityMeasurementServiceTest {

    private final IQuantityMeasurementRepository fakeRepo = entity -> {
        System.out.println("Fake save: " + entity.getMessage());
    };

    private final QuantityMeasurementServiceImpl service =
            new QuantityMeasurementServiceImpl(fakeRepo);

    @Test
    public void shouldCompareEqualLength() {

        QuantityDTO q1 = new QuantityDTO(12, "INCHES", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(1, "FEET", "LENGTH");

        QuantityMeasurementEntity result = service.compare(q1, q2);

        assertFalse(result.hasError());
        assertTrue(result.getResult()); // ✅ equal
    }

    @Test
    public void shouldCompareNotEqualLength() {

        QuantityDTO q1 = new QuantityDTO(10, "INCHES", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(1, "FEET", "LENGTH");

        QuantityMeasurementEntity result = service.compare(q1, q2);

        assertFalse(result.hasError());
        assertFalse(result.getResult()); // ❌ not equal
    }

    @Test
    public void shouldReturnErrorForInvalidType() {

        QuantityDTO q1 = new QuantityDTO(100, "CELSIUS", "TEMPERATURE");
        QuantityDTO q2 = new QuantityDTO(50, "CELSIUS", "TEMPERATURE");

        QuantityMeasurementEntity result = service.compare(q1, q2);

        assertTrue(result.hasError());
    }
}