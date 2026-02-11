package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/clinicdb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Alan@2004";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, USER, PASSWORD);
    }
}
