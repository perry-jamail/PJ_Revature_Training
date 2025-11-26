package com.revature.db.service;

import com.revature.db.dao.ExpenseDAO;
import com.revature.db.dao.ExpenseJDBCImpl;
import com.revature.db.model.Expense;
import com.revature.db.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseServiceImpl implements ExpenseService {
    public Expense getExpense(int id) {
        ExpenseDAO expenseDAO = new ExpenseJDBCImpl();
        if (id > 0) {
            Expense expense = expenseDAO.getExpense(id);
            return expense;
        } else {
            return null;
        }
    }

    public List<Expense> getAllExpenses() {
        ExpenseDAO expenseDAO = new ExpenseJDBCImpl();
        List<Expense> returnList = expenseDAO.getAllExpenses();

        if (!returnList.isEmpty()) {
            return returnList;
        } else {
            return null;
        }
    }

    public List<Expense> getAllPending() {
        ExpenseDAO expenseDAO = new ExpenseJDBCImpl();
        List<Expense> returnList = expenseDAO.getAllPending();

        if (!returnList.isEmpty()) {
            return returnList;
        } else {
            return null;
        }
    }

    public List<Expense> getAllApproved() {
        ExpenseDAO expenseDAO = new ExpenseJDBCImpl();
        List<Expense> returnList = expenseDAO.getAllApproved();

        if (!returnList.isEmpty()) {
            return returnList;
        } else {
            return null;
        }
    }

    public void update(int id, String column, String value) {
        List<Expense> fullList = getAllExpenses();
        Expense expenseToUpdate = null;

        for (Expense e : fullList) {
            if (e.getId() == id) {
                expenseToUpdate = e;
            }
        }

        if (expenseToUpdate != null) {
            if (column.equalsIgnoreCase("manager_username") ||
                    column.equalsIgnoreCase("name") ||
                    column.equalsIgnoreCase("amount") ||
                    column.equalsIgnoreCase("category") ||
                    column.equalsIgnoreCase("description") ||
                    column.equalsIgnoreCase("manager_comment")
            ) {
                if (column.equalsIgnoreCase("amount")) {
                    if (Float.parseFloat(value) > 0) {
                        ExpenseDAO expenseDAO = new ExpenseJDBCImpl();
                        expenseDAO.update(id, column, value);
                    } else {
                        System.out.println("For update to the amount of an expense, the value must be greater than 0.");
                    }
                } else {
                    ExpenseDAO expenseDAO = new ExpenseJDBCImpl();
                    expenseDAO.update(id, column, value);
                }
            } else {
                System.out.println("Invalid expense element.");
            }
        } else {
            System.out.println("There is no expense with ID '" + id + "'.");
        }
    }

    public void delete(int id) {
        List<Expense> fullList = getAllExpenses();
        Expense expenseToDelete = null;

        for (Expense e : fullList) {
            if (e.getId() == id) {
                expenseToDelete = e;
            }
        }

        if (expenseToDelete != null) {
            ExpenseDAO expenseDAO = new ExpenseJDBCImpl();
            expenseDAO.delete(id);
        } else {
            System.out.println("Expense with the ID of '\" + id + \"' does not exist.");
        }
    }
}
