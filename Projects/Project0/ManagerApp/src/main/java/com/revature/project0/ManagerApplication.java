// Class to handle the "home page" functions of the manager application.

package com.revature.project0;

import java.io.IOException;
import java.util.Scanner;

public class ManagerApplication {
    static LogIn lg = new LogIn();

    static String username = "";
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Where the application will begin running from
        welcome();
    }

    static void welcome() throws IOException {
        System.out.print("Welcome to the Manager Appplication for the Expense Manager! Please " +
                "enter (1) to login or (2) to create an account! >");
        String login_or_create = scan.next();

        if (login_or_create.equals("1")) {
            username = lg.login();
            // application();
        } else if (login_or_create.equals("2")) {
            lg.addCred();
            username = lg.login();
            // application();
        } else {
            System.out.println("Please enter either 1 or 2\n");
            welcome();
        }
    }

    static void application() {
        String op = "";
        while (!op.equals("q")) {
            System.out.print("Please enter a function to perform:\n\t1) View List of Pending Expenses\n\t" +
                    "2) Approve or Deny Pending Expenses with Comments\n\t3) Generate Report of Approved Expenses\n\t" +
                    "q) Quit Application\n> ");
            op = scan.next();

            switch (op) {
                case "1":
                    // TODO: Create functionality to View List of Pending Expenses
                    break;
                case "2":
                    // TODO: Create functionality to Approve or Deny Pending Expenses with Comments
                    break;
                case "3":
                    // TODO: Create functionality to Generate Report of Approved Expenses
                    break;
                case "q":
                    System.out.println("Quitting application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid input.\n");
            }
        }
    }
}
