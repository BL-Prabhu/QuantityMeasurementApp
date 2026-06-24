package service;

import dto.QuantityDTO;
import entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementService {

    QuantityMeasurementEntity add(QuantityDTO q1, QuantityDTO q2);

    QuantityMeasurementEntity subtract(QuantityDTO q1, QuantityDTO q2);

    QuantityMeasurementEntity compare(QuantityDTO q1, QuantityDTO q2);
}