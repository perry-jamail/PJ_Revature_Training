package com.revature.db.dao;

import com.revature.db.model.Expense;

import java.util.Date;
import java.util.List;

public interface ReportDAO {
    public List<Expense> reportAllApproved();
    public List<Expense> reportByEmpId(int id);
    public List<Expense> reportByExpCategory(String category);
    public List<Expense> reportByExpDate(String date);
}
