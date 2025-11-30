package com.revature.db.dao;

import com.revature.db.model.Expense;
import com.revature.db.service.ExpenseService;
import com.revature.db.service.ExpenseServiceImpl;
import com.revature.db.service.ReportService;
import com.revature.db.service.ReportServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ReportJDBCImpl implements ReportDAO {
    public List<Expense> reportAll() {
        ExpenseService expenseService = new ExpenseServiceImpl();

        return expenseService.getAllExpenses();
    }

    public List<Expense> reportAllApproved() {
        ExpenseService expenseService = new ExpenseServiceImpl();
        List<Expense> fullList = expenseService.getAllExpenses();
        List<Expense> approvedList = new ArrayList<>();

        for (Expense e : fullList) {
            if (e.getStatus().equalsIgnoreCase("Approved")) {
                approvedList.add(e);
            }
        }
        return approvedList;
    }

    public List<Expense> reportAllDenied() {
        ExpenseService expenseService = new ExpenseServiceImpl();
        List<Expense> fullList = expenseService.getAllExpenses();
        List<Expense> deniedList = new ArrayList<>();

        for (Expense e : fullList) {
            if (e.getStatus().equalsIgnoreCase("Denied")) {
                deniedList.add(e);
            }
        }
        return deniedList;
    }

    public List<Expense> reportAllPending() {
        ExpenseService expenseService = new ExpenseServiceImpl();
        List<Expense> fullList = expenseService.getAllExpenses();
        List<Expense> pendingList = new ArrayList<>();

        for (Expense e : fullList) {
            if (e.getStatus().equalsIgnoreCase("Pending")) {
                pendingList.add(e);
            }
        }
        return pendingList;
    }

    public List<Expense> reportByEmpId(int id) {
        ReportService reportService = new ReportServiceImpl();
        List<Expense> fullExpenseList = reportService.reportAll();
        List<Expense> empList = new ArrayList<>();

        for (Expense e : fullExpenseList) {
            if (e.getEmployee_id() == id) {
                empList.add(e);
            }
        }
        return empList;
    }

    public List<Expense> reportByExpCategory(String category) {
        ReportService reportService = new ReportServiceImpl();
        List<Expense> fullExpenseList = reportService.reportAll();
        List<Expense> catList = new ArrayList<>();

        for (Expense e : fullExpenseList) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                catList.add(e);
            }
        }
        return catList;
    }

    public List<Expense> reportByExpDate(String date) {
        ReportService reportService = new ReportServiceImpl();
        List<Expense> fullExpenseList = reportService.reportAll();
        List<Expense> dateList = new ArrayList<>();

        for (Expense e : fullExpenseList) {
            if (e.getSubmission_date().equalsIgnoreCase(date)) {
                dateList.add(e);
            }
        }
        return dateList;
    }
}
