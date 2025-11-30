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

        System.out.print("\nGenerate report based on:\n\t1) All Expenses\n\t2) All Approved Expenses\n\t3) All Denied Expenses" +
                "\n\t4) All Pending Expenses\n\t5) Employee ID" +
                "\n\t6) Expense Category\n\t7) Expense Submission Date\n\th) Return to Home Screen\n> ");
        String repOp = scan.next();

        switch (repOp) {
            case "1":
                printList = reportService.reportAll();
                logger.info("'{}' generated a report of all expenses.", username);
                break;
            case "2":
                printList = reportService.reportAllApproved();
                logger.info("'{}' generated a report of all approved expenses.", username);
                break;
            case "3":
                printList = reportService.reportAllDenied();
                logger.info("'{}' generated a report of all denied expenses.", username);
                break;
            case "4":
                printList = reportService.reportAllPending();
                logger.info("'{}' generated a report of all pending expenses.", username);
                break;
            case "5":
                System.out.print("\nEnter an employee ID to generate a report of all expenses belonging to that employee: ");
                int empId = Integer.parseInt(scan.next());
                printList = reportService.reportByEmpId(empId);
                logger.info("'{}' generated a report of all expenses under the employee with ID '{}'.", username, empId);
                break;
            case "6":
                System.out.print("\nEnter an expense category to generate a report of all expenses with that category: ");
                String expCat = scan.next();
                printList = reportService.reportByExpCategory(expCat);
                logger.info("'{}' generated a report of all expenses under the category '{}'.", username, expCat);
                break;
            case "7":
                System.out.print("\nEnter a date (YYYY-MM-DD) to generate a report of all expenses submitted on that date: ");
                String expDate = scan.next();
                printList = reportService.reportByExpDate(expDate);
                logger.info("'{}' generated a report of all expenses under the date '{}'.", username, expDate);
                break;
            case "h":
                System.out.println("Returning to home screen...\n");
                return;
            default:
                System.out.println("Invalid input. Please enter a number between 1-7, or 'h'.");
                reportOptions(username);
        }

        if (printList == null) {
            System.out.println("There are no expenses with the specified search parameters.\n");
        } else {
            System.out.println("\n************************* Start Report *************************");
            for (Expense e : printList) {
                System.out.println(e);
            }
            System.out.println("************************** End Report **************************\n");
        }
    }
}
