package quantitymeasurement.service;


import quantitymeasurement.dto.QuantityInputDTO;
import quantitymeasurement.dto.QuantityMeasurementDTO;

import java.util.List;

public interface IQuantityMeasurementService {

    QuantityMeasurementDTO compareQuantities(QuantityInputDTO input);

    QuantityMeasurementDTO convertQuantity(QuantityInputDTO input);

    QuantityMeasurementDTO addQuantities(QuantityInputDTO input);

    List<QuantityMeasurementDTO> getOperationHistory(String operation);

    List<QuantityMeasurementDTO> getMeasurementTypeHistory(String measurementType);

    List<QuantityMeasurementDTO> getErrorHistory();

    long getOperationCount(String operation);
}