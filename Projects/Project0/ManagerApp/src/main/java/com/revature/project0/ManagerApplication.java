// Class to handle the "home page" functions of the manager application.

package com.revature.project0;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.View;
import java.io.IOException;
import java.util.Scanner;

public class ManagerApplication {
    static LogIn lg = new LogIn();
    static ViewPending vp = new ViewPending();
    static ApproveDenyPending adp = new ApproveDenyPending();
    static GenerateReport gr = new GenerateReport();

    static String username = "";
    static Scanner scan = new Scanner(System.in);
    static Logger logger = LoggerFactory.getLogger(ManagerApplication.class);

    public static void main(String[] args) throws IOException {
        // Where the application will begin running from
        welcome();
    }

    static void welcome() throws IOException {
        System.out.print("Welcome to the Manager Appplication for the Expense Manager! Please " +
                "enter (1) to login or (2) to create an account! > ");
        String login_or_create = scan.next();

        if (login_or_create.equals("1")) {
            username = lg.login();
            application();
        } else if (login_or_create.equals("2")) {
            lg.addCred();
            username = lg.login();
            application();
        } else {
            System.out.println("Please enter either 1 or 2\n");
            welcome();
        }
    }

    static void application() throws IOException {
        String op = "";
        while (!op.equals("q")) {
            System.out.print("Please enter a function to perform:\n\t1) View List of Pending Expenses\n\t" +
                    "2) Approve or Deny Pending Expenses with Comments\n\t3) Generate Report of Approved Expenses\n\t" +
                    "q) Quit Application\n> ");
            op = scan.next();

            switch (op) {
                case "1":
                    vp.viewAllPendingExpenses();
                    logger.info("'{}' has viewed all pending expenses.", username);
                    break;
                case "2":
                    adp.approveDenyPending(username);
                    break;
                case "3":
                    gr.reportOptions(username);
                    break;
                case "q":
                    System.out.println("Quitting application...");
                    logger.info("Application quit.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid input.\n");
            }
        }
    }
}
