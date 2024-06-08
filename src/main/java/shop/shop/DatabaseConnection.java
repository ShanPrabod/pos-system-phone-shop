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

}

