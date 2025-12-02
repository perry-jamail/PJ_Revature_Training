package com.revature.db;

import com.revature.db.model.Expense;
import com.revature.db.service.ExpenseService;
import com.revature.db.service.ExpenseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.tablesaw.api.*;

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
            welcome();
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
                    "2) Approve or Deny Pending Expenses with Comments\n\t3) Generate Report of Expenses\n\t" +
                    "q) Quit Application\n> ");
            op = scan.next();

            switch (op) {
                case "1":
                    List<Expense> results = es.getAllPending();
                    if (results == null) {
                        System.out.println("\nNo Pending Expenses\n");
                    } else {
                        Table resultTable = Table.create("Report");
                        resultTable.addColumns(
                                IntColumn.create("ID"),
                                IntColumn.create("Employee ID"),
                                StringColumn.create("Manager Username"),
                                StringColumn.create("Expense Name"),
                                StringColumn.create("Submission Date"),
                                FloatColumn.create("Amount"),
                                StringColumn.create("Category"),
                                StringColumn.create("Status"),
                                StringColumn.create("Description"),
                                StringColumn.create("Manager Comment")
                        );

                        for (Expense e : results) {
                            Row newRow = resultTable.appendRow();
                            newRow.setInt("ID", e.getId());
                            newRow.setInt("Employee ID", e.getEmployee_id());
                            newRow.setString("Manager Username", e.getManager_username());
                            newRow.setString("Expense Name", e.getName());
                            newRow.setString("Submission Date", e.getSubmission_date());
                            newRow.setFloat("Amount", e.getAmount());
                            newRow.setString("Category", e.getCategory());
                            newRow.setString("Status", e.getStatus());
                            newRow.setString("Description", e.getDescription());
                            newRow.setString("Manager Comment", e.getManager_comment());
                        }
                        System.out.println(resultTable.print() + "\n");
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
