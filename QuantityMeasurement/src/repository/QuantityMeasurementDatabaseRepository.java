package repository;

import entity.QuantityMeasurementEntity;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuantityMeasurementDatabaseRepository
        implements IQuantityMeasurementRepository {

    @Override
    public void save(QuantityMeasurementEntity entity) {

        String sql = """
            INSERT INTO quantity_measurement (operation, result, error)
            VALUES (?, ?, ?)
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entity.toString());

            ps.setString(2,
                    entity.hasError() ? null : entity.toString()
            );

            ps.setString(3,
                    entity.hasError() ? entity.toString() : null
            );

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("DB Insert Failed", e);
        }
    }
}