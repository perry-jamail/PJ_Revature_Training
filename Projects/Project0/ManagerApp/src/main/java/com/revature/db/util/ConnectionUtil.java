package com.revature.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    static Connection connection = null;
    public static Connection dbConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ExpenseManager", "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
