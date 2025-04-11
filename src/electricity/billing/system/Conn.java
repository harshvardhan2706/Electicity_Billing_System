package electricity.billing.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "hv@123");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
