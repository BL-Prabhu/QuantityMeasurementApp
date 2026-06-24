package service;

import dto.QuantityDTO;
import entity.QuantityMeasurementEntity;
import exception.QuantityMeasurementException;
import model.LengthUnit;
import repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    private double convertToFeet(double value, String unit) {
        return value * LengthUnit.valueOf(unit).getConversionFactor();
    }

    @Override
    public QuantityMeasurementEntity add(QuantityDTO q1, QuantityDTO q2) {
        try {
            double v1 = convertToFeet(q1.getValue(), q1.getUnit());
            double v2 = convertToFeet(q2.getValue(), q2.getUnit());

            double result = v1 + v2;

            QuantityMeasurementEntity entity =
                    new QuantityMeasurementEntity("ADD", result + " FEET");

            repository.save(entity);
            return entity;

        } catch (Exception e) {
            return new QuantityMeasurementEntity(e.getMessage());
        }
    }

    @Override
    public QuantityMeasurementEntity subtract(QuantityDTO q1, QuantityDTO q2) {
        try {
            double v1 = convertToFeet(q1.getValue(), q1.getUnit());
            double v2 = convertToFeet(q2.getValue(), q2.getUnit());

            double result = v1 - v2;

            QuantityMeasurementEntity entity =
                    new QuantityMeasurementEntity("SUBTRACT", result + " FEET");

            repository.save(entity);
            return entity;

        } catch (Exception e) {
            return new QuantityMeasurementEntity(e.getMessage());
        }
    }

    @Override
    public QuantityMeasurementEntity compare(QuantityDTO q1, QuantityDTO q2) {
        try {
            double v1 = convertToFeet(q1.getValue(), q1.getUnit());
            double v2 = convertToFeet(q2.getValue(), q2.getUnit());

            String result = (v1 == v2) ? "EQUAL" : "NOT EQUAL";

            QuantityMeasurementEntity entity =
                    new QuantityMeasurementEntity("COMPARE", result);

            repository.save(entity);
            return entity;

        } catch (Exception e) {
            return new QuantityMeasurementEntity(e.getMessage());
        }
    }
}