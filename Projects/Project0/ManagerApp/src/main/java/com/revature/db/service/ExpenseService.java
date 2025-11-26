package com.revature.db.service;

import com.revature.db.model.Expense;

import java.util.List;

public interface ExpenseService {
    public List<Expense> getAllExpenses();
    public Expense getExpense(int id);
    public List<Expense> getAllPending();
    public List<Expense> getAllApproved();

    public void update(int id, String column, String value);
    public void delete(int id);
}
