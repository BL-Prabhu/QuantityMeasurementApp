package service;

import dto.QuantityDTO;
import entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementService {

    QuantityMeasurementEntity compare(QuantityDTO q1, QuantityDTO q2);
}