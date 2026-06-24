package app;

import controller.QuantityMeasurementController;
import dto.QuantityDTO;
import repository.QuantityMeasurementCacheRepository;
import service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        var repository = QuantityMeasurementCacheRepository.getInstance();
        var service = new QuantityMeasurementServiceImpl(repository);
        var controller = new QuantityMeasurementController(service);

        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(12, "INCHES", "LENGTH");

        controller.performAdd(q1, q2);
        controller.performSubtract(q1, q2);
        controller.performCompare(q1, q2);
    }
}