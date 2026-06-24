package test;

import model.LengthUnit;
import model.Quantity;
import service.QuantityService;
import service.QuantityServiceImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuantityServiceTest {

    private final QuantityService service =
            new QuantityServiceImpl();

    @Test
    public void testComparisonEqual() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12, LengthUnit.INCHES);

        assertEquals(0, service.compare(q1, q2));
    }

    @Test
    public void testSorting() {

        List<Quantity<LengthUnit>> list = Arrays.asList(
                new Quantity<>(3, LengthUnit.FEET),
                new Quantity<>(24, LengthUnit.INCHES),
                new Quantity<>(1, LengthUnit.YARDS)
        );

        List<Quantity<LengthUnit>> sorted = service.sort(list);

        assertTrue(sorted.get(0).compareTo(sorted.get(1)) <= 0);
    }
}