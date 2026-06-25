package controller;

import dto.QuantityDTO;
import entity.QuantityMeasurementEntity;
import service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public void performComparison(QuantityDTO q1, QuantityDTO q2) {

        QuantityMeasurementEntity result = service.compare(q1, q2);

        if (result.hasError()) {
            System.out.println("❌ Error: " + result.getMessage());
        } else {
            System.out.println("✅ Result: " + result.getResult());
        }
    }
}