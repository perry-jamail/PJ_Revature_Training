package com.revature.db.dao;

import com.revature.db.model.Expense;
import com.revature.db.service.ExpenseService;
import com.revature.db.service.ExpenseServiceImpl;
import com.revature.db.service.ReportService;
import com.revature.db.service.ReportServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ReportJDBCImpl implements ReportDAO {
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

    public List<Expense> reportByEmpId(int id) {
        ReportService reportService = new ReportServiceImpl();
        List<Expense> fullApprovalList = reportService.reportAllApproved();
        List<Expense> empApprovedList = new ArrayList<>();

        for (Expense e : fullApprovalList) {
            if (e.getEmployee_id() == id) {
                empApprovedList.add(e);
            }
        }
        return empApprovedList;
    }

    public List<Expense> reportByExpCategory(String category) {
        ReportService reportService = new ReportServiceImpl();
        List<Expense> fullApprovalList = reportService.reportAllApproved();
        List<Expense> catApprovedList = new ArrayList<>();

        for (Expense e : fullApprovalList) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                catApprovedList.add(e);
            }
        }
        return catApprovedList;
    }

    public List<Expense> reportByExpDate(String date) {
        ReportService reportService = new ReportServiceImpl();
        List<Expense> fullApprovalList = reportService.reportAllApproved();
        List<Expense> dateApprovedList = new ArrayList<>();

        for (Expense e : fullApprovalList) {
            if (e.getSubmission_date().equalsIgnoreCase(date)) {
                dateApprovedList.add(e);
            }
        }
        return dateApprovedList;
    }
}
