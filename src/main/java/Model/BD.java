package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

    private static final String URL = "jdbc:derby://localhost:1527/ST2EEDB";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getCo() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
