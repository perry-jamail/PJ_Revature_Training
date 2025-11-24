package com.revature.DAODemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    static Connection connection = null;
    public static Connection dbConnection() {
        try {
            // Do not use hard coded username and password. Use a separate file under the resources folder
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
