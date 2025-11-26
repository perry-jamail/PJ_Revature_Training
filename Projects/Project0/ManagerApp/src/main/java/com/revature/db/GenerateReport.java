package com.revature.db;

import com.revature.db.model.Expense;
import com.revature.db.service.ReportService;
import com.revature.db.service.ReportServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class GenerateReport {
    Logger logger = LoggerFactory.getLogger(GenerateReport.class);
    public void reportOptions(String username) {
        Scanner scan = new Scanner(System.in);
        ReportService reportService = new ReportServiceImpl();
        List<Expense> printList = null;

        System.out.print("\nGenerate report based on:\n\t1) All Approved Expenses" + "\n\t2) Employee ID" +
                "\n\t3) Expense Category\n\t4) Expense Submission Date\n\th) Return to Home Screen\n> ");
        String repOp = scan.next();

        switch (repOp) {
            case "1":
                printList = reportService.reportAllApproved();
                logger.info("'{}' generated a report of all approved expenses.", username);
                break;
            case "2":
                System.out.print("\nEnter an employee ID to generate a report of all approved expenses belonging to that employee: ");
                int empId = Integer.parseInt(scan.next());
                printList = reportService.reportByEmpId(empId);
                logger.info("'{}' generated a report of all approved expenses under the employee with ID '{}'.", username, empId);
                break;
            case "3":
                System.out.print("\nEnter an expense category to generate a report of all approved expenses with that category: ");
                String expCat = scan.next();
                printList = reportService.reportByExpCategory(expCat);
                logger.info("'{}' generated a report of all approved expenses under the category '{}'.", username, expCat);
                break;
            case "4":
                System.out.print("\nEnter a date (YYYY-MM-DD) to generate a report of all approved expenses submitted on that date: ");
                String expDate = scan.next();
                printList = reportService.reportByExpDate(expDate);
                logger.info("'{}' generated a report of all approved expenses under the date '{}'.", username, expDate);
                break;
            case "h":
                System.out.println("Returning to home screen...\n");
                break;
            default:
                System.out.println("Invalid input. Please enter a number between 1-3, or 'h'.");
                reportOptions(username);
        }

        if (printList == null && !repOp.equalsIgnoreCase("h")) {
            System.out.println("There are no approved expenses with the specified search parameters.\n");
        } else if (printList != null) {
            System.out.println("\n************************* Approved Expenses *************************");
            for (Expense e : printList) {
                System.out.println(e);
            }
            System.out.println(" **************************** End List *****************************\n");
        }
    }
}
