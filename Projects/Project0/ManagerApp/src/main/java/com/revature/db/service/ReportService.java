package com.revature.db.service;

import com.revature.db.model.Expense;

import java.util.List;

public interface ReportService {
    public List<Expense> reportAll();
    public List<Expense> reportAllApproved();
    public List<Expense> reportAllDenied();
    public List<Expense> reportAllPending();

    public List<Expense> reportByEmpId(int id);
    public List<Expense> reportByExpCategory(String category);
    public List<Expense> reportByExpDate(String date);
}
