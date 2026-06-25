package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void init() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb");

            Statement stmt = conn.createStatement();

            stmt.execute("CREATE TABLE IF NOT EXISTS quantity_measurement (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "result BOOLEAN," +
                    "error BOOLEAN," +
                    "message VARCHAR(255))");

            System.out.println("✅ H2 Database initialized");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}