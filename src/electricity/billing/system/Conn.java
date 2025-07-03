package electricity.billing.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            // Connect to database
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/ebs", "postgres", "92844");
            s = c.createStatement();
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
