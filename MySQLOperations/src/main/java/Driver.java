import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Driver {
    static Connection connect() {
        try {
            String myUrl = "jdbc:mysql://localhost/st";
            Connection conn = DriverManager.getConnection(myUrl, "root", "vino");
            System.out.println("connected to the st database");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}