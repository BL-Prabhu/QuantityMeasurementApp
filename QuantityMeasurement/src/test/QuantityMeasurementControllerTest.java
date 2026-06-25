package test;

import controller.QuantityMeasurementController;
import dto.QuantityDTO;
import org.junit.Test;
import repository.QuantityMeasurementDatabaseRepository;
import service.IQuantityMeasurementService;
import service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementControllerTest {

    @Test
    public void shouldCallServiceFromController() {

        QuantityMeasurementServiceImpl service =
                new QuantityMeasurementServiceImpl(
                        new QuantityMeasurementDatabaseRepository()
                );

        QuantityMeasurementController controller =
                new QuantityMeasurementController((IQuantityMeasurementService) service);

        QuantityDTO q1 = new QuantityDTO(12, "INCH", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(1, "FEET", "LENGTH");

        controller.performComparison(q1, q2);

        System.out.println("Controller executed successfully");
    }
}