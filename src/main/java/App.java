import config.AppConfig;
import utils.PropertyReaderUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class App {

    public static void main (String[] arcs) {
        PropertyReaderUtil.readAppProperty();
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
