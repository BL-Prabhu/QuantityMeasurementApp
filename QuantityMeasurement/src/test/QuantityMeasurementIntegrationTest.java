package test;

import controller.QuantityMeasurementController;
import dto.QuantityDTO;
import org.junit.Test;
import repository.QuantityMeasurementDatabaseRepository;
import service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementIntegrationTest {

    @Test
    public void shouldExecuteFullFlowAndPersistData() {

        // Arrange
        QuantityMeasurementDatabaseRepository repo =
                new QuantityMeasurementDatabaseRepository();

        QuantityMeasurementServiceImpl service =
                new QuantityMeasurementServiceImpl(repo);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        QuantityDTO q1 = new QuantityDTO(24, "INCH", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(2, "FEET", "LENGTH");

        // Act
        controller.performComparison(q1, q2);

        // Assert (manual check DB or logs)
        System.out.println("Integration test executed successfully");
    }
}