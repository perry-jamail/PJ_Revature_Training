package com.revature.db;

import com.revature.db.model.Expense;
import com.revature.db.service.ReportService;
import com.revature.db.service.ReportServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.tablesaw.api.*;

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
                return;
        }

        if (printList == null) {
            System.out.println("There are no expenses with the specified search parameters.\n");
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

            for (Expense e : printList) {
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
        }
    }
}
