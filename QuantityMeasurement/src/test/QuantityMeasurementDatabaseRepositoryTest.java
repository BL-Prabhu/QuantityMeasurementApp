package test;

import entity.QuantityMeasurementEntity;
import org.junit.Test;
import repository.QuantityMeasurementDatabaseRepository;

public class QuantityMeasurementDatabaseRepositoryTest {

    @Test
    public void shouldSaveDataInDatabase() {

        QuantityMeasurementDatabaseRepository repo =
                new QuantityMeasurementDatabaseRepository();

        // ✅ FIXED HERE
        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(
                        true,      // result
                        false,     // hasError
                        "COMPARE"  // message
                );

        repo.save(entity);

        System.out.println("Data saved successfully");
    }
}