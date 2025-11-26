package com.revature.db.service;

import com.revature.db.dao.ReportDAO;
import com.revature.db.dao.ReportJDBCImpl;
import com.revature.db.model.Expense;

import java.util.Date;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    public List<Expense> reportAllApproved() {
        ReportDAO reportDAO = new ReportJDBCImpl();
        List<Expense> returnList = reportDAO.reportAllApproved();

        if (!returnList.isEmpty()) {
            return returnList;
        } else {
            return null;
        }
    }

    public List<Expense> reportByEmpId(int id) {
        ReportDAO reportDAO = new ReportJDBCImpl();
        List<Expense> returnList = reportDAO.reportByEmpId(id);

        if (!returnList.isEmpty()) {
            return returnList;
        } else {
            return null;
        }
    }

    public List<Expense> reportByExpCategory(String category) {
        ReportDAO reportDAO = new ReportJDBCImpl();
        List<Expense> returnList = reportDAO.reportByExpCategory(category);

        if (!returnList.isEmpty()) {
            return returnList;
        } else {
            return null;
        }
    }

    public List<Expense> reportByExpDate(Date date) {
        ReportDAO reportDAO = new ReportJDBCImpl();
        List<Expense> returnList = reportDAO.reportByExpDate(date);

        if (!returnList.isEmpty()) {
            return returnList;
        } else {
            return null;
        }
    }
}
