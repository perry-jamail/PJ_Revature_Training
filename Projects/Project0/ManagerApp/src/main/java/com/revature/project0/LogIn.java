// Class for handling log-in functionality for the manager app.

package com.revature.project0;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class LogIn {
    Logger logger = LoggerFactory.getLogger(LogIn.class);

    public String login() throws IOException {
        ObjectNode credentialsList = openJSON();
        String username = "";
        Scanner scan = new Scanner(System.in);

        while (!Objects.equals(username, "q")) {
            System.out.println("\n%% Login ('q' to quit) %%");
            System.out.print("Enter your username: ");
            username = scan.next();

            if (credentialsList.has(username)) {
                System.out.print("Enter your password: ");
                String password = scan.next();
                String storedPassword = credentialsList.findValuesAsText(username).getFirst();
                if (storedPassword.equals(password)) {
                    System.out.println("Authentication successful. Logged in as '" + username + "'.\n");
                    logger.info("'{}' logged in.", username);
                    return username;
                } else {
                    System.out.println("Username exists, but the password is incorrect.\n");
                    logger.warn("Unsuccessful login attempt for account '{}'.", username);
                }
            } else if (!Objects.equals(username, "q")) {
                System.out.println("Username not found.\n");
            }
        }
        if (username.equals("q")) {
            System.out.println("Quitting application...");
            logger.info("Application quit.");
            System.exit(0);
        }
        return "";
    }

    public void addCred() throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n%% New Account Creation ('q' to quit) %%");
        System.out.print("Enter your new account's username: ");
        String username = scan.next();

        ObjectNode credentials = openJSON();
        if ((!credentials.has(username)) && (!username.equals("q"))) {
            System.out.print("Enter your new account's password: ");
            String password = scan.next();
            credentials.put(username, password);
            saveCred(credentials);
            System.out.println("Account with the username '" + username + "' was successfully created.");
            logger.info("Account created with username '{}'.", username);
        } else if (username.equals("q")) {
            System.out.println("Quitting application...");
            logger.info("Application quit.");
            System.exit(0);
        } else {
            System.out.println("Username already exists.\n");
            logger.warn("Duplicate account creation attempted for '{}'.", username);
        }
    }

    public boolean checkCred(String username) throws IOException {
        ObjectNode credentials = openJSON();

        if (credentials.has(username)) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the password associated with the account '" + username + "': ");
            String pswd = scan.next();
            String storedPassword = credentials.findValuesAsText(username).getFirst();

            if (storedPassword.equals(pswd)) {
                return true;
            } else {
                System.out.println("Incorrect password.");
                return false;
            }
        } else {
            System.out.println("Username not found.");
            return false;
        }
    }

    public ObjectNode openJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = new String(Files.readAllBytes(Paths.get("managerCredentials.json")));
        JsonNode jsonNode = mapper.readTree(jsonString);
        return (ObjectNode) jsonNode;
    }

    public void saveCred(ObjectNode credToSave) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("managerCredentials.json"), credToSave);
    }
}
