package shop.shop;

import java.sql.*;
public class DatabaseConnection {
    private Connection connection;
    public static Connection connectDb(){
        String url = "jdbc:mysql://localhost:3306/phoneShop";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url, username, password);
            return connect;
        }catch (Exception e){e.printStackTrace();}
        return null;
    }
/*
    private DatabaseConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/phone_shop";  // Update with your database details
        String username = "root";  // Update with your username
        String password = "password";  // Update with your password
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
    }

    public static synchronized DatabaseConnection getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return connection;
    }

    // Method to close the connection (Optional)
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }*/
}

