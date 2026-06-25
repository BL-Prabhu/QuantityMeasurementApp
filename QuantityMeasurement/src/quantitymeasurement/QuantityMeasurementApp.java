package quantitymeasurement;

import controller.QuantityMeasurementController;
import dto.QuantityDTO;
import repository.IQuantityMeasurementRepository;
import repository.QuantityMeasurementDatabaseRepository;
import service.IQuantityMeasurementService;
import service.QuantityMeasurementServiceImpl;
import util.DatabaseInitializer;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // ✅ Init DB
        DatabaseInitializer.init();

        IQuantityMeasurementRepository repo =
                new QuantityMeasurementDatabaseRepository();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repo); // ✅ FIXED

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        // ✅ USE CASE 16
        controller.performComparison(
                new QuantityDTO(1, "FEET", "LENGTH"),
                new QuantityDTO(12, "INCHES", "LENGTH") // ✅ MUST match enum
        );
    }
}