package studentmgmt;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // load the driver
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/student_mgmt";
            String user = "animesh";
            String password = "postgres";

            connection = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
