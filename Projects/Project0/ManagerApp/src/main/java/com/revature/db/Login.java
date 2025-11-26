package com.revature.db;

import com.revature.db.model.Manager;
import com.revature.db.util.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    Connection connection = null;
    Manager manager = null;
    Scanner scan;
    String username;
    Logger logger = LoggerFactory.getLogger(Login.class);

    public String login() {
        connection = ConnectionUtil.dbConnection();
        scan = new Scanner(System.in);

        while (!Objects.equals(username, "q")) {
            System.out.println("\n%% Login ('q' to quit) %%");
            System.out.print("Enter your username: ");
            username = scan.next();

            String getManager = "select * from managers where username=?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(getManager);
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    manager = new Manager(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    );
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (manager != null) {
                System.out.print("Enter your password: ");
                String password = scan.next();

                if (password.equals(manager.getPassword())) {
                    System.out.println("Authentication successful. Logged in as '" + username + "'.\n");
                    logger.info("'{}' logged in.", username);
                    return username;
                } else {
                    System.out.println("Username exists, but the password is incorrect.");
                    logger.warn("Unsuccessful login attempt for account '{}'.", username);
                }
            } else {
                System.out.println("Username not found.");
            }
        }

        System.out.println("Quitting application...");
        logger.info("Application quit.");
        System.exit(0);
        return "";
    }

    public void addCred() {
        connection = ConnectionUtil.dbConnection();
        scan = new Scanner(System.in);

        System.out.println("\n%% New Account Creation ('q' to quit) %%");
        System.out.print("Enter your new account's username: ");
        username = scan.next();

        String getManager = "select * from managers where username=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getManager);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                manager = new Manager(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (manager == null && !username.equalsIgnoreCase("q")) {
            System.out.print("Enter your new account's password: ");
            String password = scan.next();

            String createManager = "insert into managers(username, password) values(?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(createManager);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted.");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Account with the username '" + username + "' was successfully created.");
            logger.info("Account created with username '{}'.", username);
        } else if (username.equalsIgnoreCase("q")) {
            System.out.println("Quitting application...");
            logger.info("Application quit.");
            System.exit(0);
        } else {
            System.out.println("Username already exists.\n");
            logger.warn("Duplicate account creation attempted for '{}'.", username);
        }
    }
}
