package com.revature.db.dao;

import com.revature.db.service.ExpenseService;
import com.revature.db.service.ExpenseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ManagerFuncJDBCImpl implements ManagerFuncDAO {
    Logger logger = LoggerFactory.getLogger(ManagerFuncJDBCImpl.class);
    public void approvePending(int id, String username) {
        Scanner scan = new Scanner(System.in);
        ExpenseService expenseService = new ExpenseServiceImpl();

        System.out.print("Enter the Manager Comment associated with the approval of this pending expense: ");
        String managerComment = scan.nextLine();

        expenseService.update(id, "manager_username", username);
        expenseService.update(id, "status", "Approved");
        expenseService.update(id, "manager_comment", managerComment);

        System.out.println("\nExpense with ID '" + id + "' was successfully approved.\n");
        logger.info("'{}' approved pending expense with ID '{}'.", username, id);
    }

    public void denyPending(int id, String username) {
        Scanner scan = new Scanner(System.in);
        ExpenseService expenseService = new ExpenseServiceImpl();

        System.out.print("Enter the Manager Comment associated with the denial of this pending expense: ");
        String managerComment = scan.nextLine();

        expenseService.update(id, "manager_username", username);
        expenseService.update(id, "status", "Denied");
        expenseService.update(id, "manager_comment", managerComment);

        System.out.println("\nExpense with ID '" + id + "' was successfully denied.\n");
        logger.info("'{}' denied pending expense with ID '{}'.", username, id);
    }
}
