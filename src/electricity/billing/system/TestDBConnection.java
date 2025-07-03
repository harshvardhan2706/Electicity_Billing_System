package electricity.billing.system;

import java.sql.*;

public class TestDBConnection {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/ebs", "postgres", "92844");
            System.out.println("Database connection successful!");

            String[] tables = {"login", "customer", "meter_info", "tax", "bill"};
            DatabaseMetaData dbm = c.getMetaData();
            for (String table : tables) {
                ResultSet rs = dbm.getTables(null, null, table, null);
                if (rs.next()) {
                    System.out.println("Table '" + table + "' exists.");
                } else {
                    System.out.println("Table '" + table + "' does NOT exist!");
                }
                rs.close();
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
