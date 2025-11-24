package com.revature.JDBCDemo;

import java.sql.*;

public class JdbcStmt01 {
    static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        // STEP 1. Load the driver --
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // STEP 2. Create the connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
            // STEP 3. - Create the statement obj
            statement = connection.createStatement();
            String selectQuery = "select * from contacts";
            // STEP 4. Execute the query and collect the result in result set
            resultSet = statement.executeQuery(selectQuery);
            // STEP 5. Process the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("contact_id") + ". " + resultSet.getString(2));

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Database Connected...");
    }
}
