package com.revature.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class Login {
    Scanner scan;
    String username;
    Logger logger = LoggerFactory.getLogger(Login.class);
    Properties properties = new Properties();

    public String login() {
        scan = new Scanner(System.in);
        try {
            properties.load(new FileInputStream("C:\\Users\\perry\\Revature\\Projects\\Project0\\ManagerApp\\src\\main\\resources\\credentials.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (!Objects.equals(username, "q")) {
            System.out.println("\n%% Login ('q' to quit) %%");
            System.out.print("Enter your username: ");
            username = scan.next();
            String propUser = properties.getProperty(username);

            if (propUser != null) {
                System.out.print("Enter your password: ");
                String password = scan.next();

                if (password.equals(propUser)) {
                    System.out.println("Authentication successful. Logged in as '" + username + "'.\n");
                    logger.info("'{}' logged in.", username);
                    return username;
                } else {
                    System.out.println("Username exists, but the password is incorrect.");
                    logger.warn("Unsuccessful login attempt for account '{}'.", username);
                }
            } else if (!username.equalsIgnoreCase("q")) {
                System.out.println("Username not found.");
            }
        }

        System.out.println("Quitting application...");
        logger.info("Application quit.");
        System.exit(0);
        return "";
    }

    public void addCred() {
        scan = new Scanner(System.in);
        try {
            properties.load(new FileInputStream("C:\\Users\\perry\\Revature\\Projects\\Project0\\ManagerApp\\src\\main\\resources\\credentials.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n%% New Account Creation ('q' to quit) %%");
        System.out.print("Enter your new account's username: ");
        username = scan.next();
        String propUser = properties.getProperty(username);

        if (propUser == null && !username.equalsIgnoreCase("q")) {
            System.out.print("Enter your new account's password: ");
            String password = scan.next();

            properties.setProperty(username, password);
            try {
                properties.store(new FileOutputStream("C:\\Users\\perry\\Revature\\Projects\\Project0\\ManagerApp\\src\\main\\resources\\credentials.properties"), "New properties added.");
            } catch (IOException e) {
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
