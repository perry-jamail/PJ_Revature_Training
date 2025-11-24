package com.revature.JDBCDemo;

import java.sql.*;

public class JdbcPSDemo {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    static void main(String[] args) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
            String insertQuery = "insert into contacts(name, email, phone) values(?,?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "Perry");
            preparedStatement.setString(2, "25");
//            preparedStatement.setString(3, "1234567890");
            preparedStatement.execute();
            preparedStatement.close();

            String selectQuery = "select * from contacts where name like ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, "Harper");
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
