package com.revature.db;

import com.revature.db.model.Expense;
import com.revature.db.service.ExpenseService;
import com.revature.db.service.ExpenseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    static String username;
    static Login lg;
    static Logger logger;
    static ExpenseService es = new ExpenseServiceImpl();
    static GenerateReport gr = new GenerateReport();
    static ApproveDeny ad = new ApproveDeny();

    static void main(String[] args) {
        welcome();
    }

    static void welcome() {
        scan = new Scanner(System.in);
        lg = new Login();

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

    static void application() {
        scan = new Scanner(System.in);
        logger = LoggerFactory.getLogger(Main.class);

        String op = "";
        while (!op.equals("q")) {
            System.out.print("Please enter a function to perform:\n\t1) View List of Pending Expenses\n\t" +
                    "2) Approve or Deny Pending Expenses with Comments\n\t3) Generate Report of Approved Expenses\n\t" +
                    "q) Quit Application\n> ");
            op = scan.next();

            switch (op) {
                case "1":
                    List<Expense> results = es.getAllPending();
                    if (results == null) {
                        System.out.println("\nNo Pending Expenses\n");
                    } else {
                        System.out.println("\n************************* Pending Expenses *************************");
                        for (Expense e : results) {
                            System.out.println(e);
                        }
                        System.out.println("***************************** End List *****************************\n");
                        logger.info("'{}' viewed all pending expenses.", username);
                    }
                    break;
                case "2":
                    ad.managerFuncOptions(username);
                    break;
                case "3":
                    gr.reportOptions(username);
                    break;
                case "q":
                    scan.close();
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
