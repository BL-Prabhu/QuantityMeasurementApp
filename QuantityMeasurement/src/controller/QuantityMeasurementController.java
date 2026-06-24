package controller;

import dto.QuantityDTO;
import entity.QuantityMeasurementEntity;
import service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public void performAdd(QuantityDTO q1, QuantityDTO q2) {
        QuantityMeasurementEntity result = service.add(q1, q2);
        System.out.println(result);
    }

    public void performSubtract(QuantityDTO q1, QuantityDTO q2) {
        System.out.println(service.subtract(q1, q2));
    }

    public void performCompare(QuantityDTO q1, QuantityDTO q2) {
        System.out.println(service.compare(q1, q2));
    }
}