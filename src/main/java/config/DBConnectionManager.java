package config;

import java.sql.*;

public final class DBConnectionManager {
    private static boolean connected = false;
    private static Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/dealership";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() {
        if (!connected) {
            connect();
        }
        return connection;
    }

    private static void connect() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
