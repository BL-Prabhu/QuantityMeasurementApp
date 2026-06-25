package service;

import dto.QuantityDTO;
import entity.QuantityMeasurementEntity;
import model.LengthUnit;
import model.Quantity;
import repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuantityMeasurementEntity compare(QuantityDTO q1, QuantityDTO q2) {

        try {
            // ✅ Validate type
            if (!q1.getType().equalsIgnoreCase("LENGTH") ||
                    !q2.getType().equalsIgnoreCase("LENGTH")) {

                QuantityMeasurementEntity error =
                        new QuantityMeasurementEntity(false, true, "Invalid Type");

                repository.save(error);
                return error;
            }

            // ✅ Convert String → Enum (IMPORTANT FIX)
            LengthUnit u1 = LengthUnit.valueOf(q1.getUnit().toUpperCase());
            LengthUnit u2 = LengthUnit.valueOf(q2.getUnit().toUpperCase());

            Quantity<LengthUnit> quantity1 = new Quantity<>(q1.getValue(), u1);
            Quantity<LengthUnit> quantity2 = new Quantity<>(q2.getValue(), u2);

            // ✅ Compare
            boolean result = quantity1.equals(quantity2);

            QuantityMeasurementEntity entity =
                    new QuantityMeasurementEntity(result, false, "Success");

            repository.save(entity);

            return entity;

        } catch (Exception e) {

            QuantityMeasurementEntity error =
                    new QuantityMeasurementEntity(false, true, e.getMessage());

            repository.save(error);
            return error;
        }
    }
}