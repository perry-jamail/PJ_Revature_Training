package com.revature.db.service;

import com.revature.db.dao.ManagerFuncDAO;
import com.revature.db.dao.ManagerFuncJDBCImpl;
import com.revature.db.model.Expense;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ManagerFuncServiceImpl implements ManagerFuncService {
    Logger logger = LoggerFactory.getLogger(ManagerFuncServiceImpl.class);
    public void approvePending(int id, String username) {
        ExpenseService expenseService = new ExpenseServiceImpl();
        ManagerFuncDAO managerFuncDAO = new ManagerFuncJDBCImpl();
        List<Expense> pendingList = expenseService.getAllPending();
        Expense expenseToApprove = null;

        if (pendingList != null) {
            for (Expense e : pendingList) {
                if (e.getId() == id) {
                    expenseToApprove = e;
                }
            }
        }

        if (expenseToApprove != null) {
            managerFuncDAO.approvePending(id, username);
        } else {
            System.out.println("There are no pending expenses with the ID of '" + id + "'.\n");
            logger.warn("'{}' attempted to approve expense with the ID '{}', but not pending expense exists" +
                    " with that ID.", username, id);
        }
    }

    public void denyPending(int id, String username) {
        ExpenseService expenseService = new ExpenseServiceImpl();
        ManagerFuncDAO managerFuncDAO = new ManagerFuncJDBCImpl();
        List<Expense> pendingList = expenseService.getAllPending();
        Expense expenseToDeny = null;

        if (pendingList != null) {
            for (Expense e : pendingList) {
                if (e.getId() == id) {
                    expenseToDeny = e;
                }
            }
        }

        if (expenseToDeny != null) {
            managerFuncDAO.denyPending(id, username);
        } else {
            System.out.println("There are no pending expenses with the ID of '" + id + "'.\n");
            logger.warn("'{}' attempted to deny expense with the ID '{}', but not pending expense exists" +
                    " with that ID.", username, id);
        }
    }
}
