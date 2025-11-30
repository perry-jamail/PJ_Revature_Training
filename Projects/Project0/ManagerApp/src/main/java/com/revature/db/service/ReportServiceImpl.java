package com.revature.db.service;

import com.revature.db.dao.ReportDAO;
import com.revature.db.dao.ReportJDBCImpl;
import com.revature.db.model.Expense;

import java.util.Date;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    public List<Expense> reportAll() {
        ReportDAO reportDAO = new ReportJDBCImpl();
        List<Expense> returnList = reportDAO.reportAll();

        if (!returnList.isEmpty()) {
            return returnList;
        } else {
            return null;
        }
    }

    public List<Expense> reportAllApproved() {
        ReportDAO reportDAO = new ReportJDBCImpl();
        List<Expense> returnList = reportDAO.reportAllApproved();

        if (!returnList.isEmpty()) {
            return returnList;
        } else {
            return null;
        }
    }

    public List<Expense> reportAllDenied() {
        ReportDAO reportDAO = new ReportJDBCImpl();
        List<Expense> returnList = reportDAO.reportAllDenied();

        if (!returnList.isEmpty()) {
            return returnList;
        } else {
            return null;
        }
    }

    public List<Expense> reportAllPending() {
        ReportDAO reportDAO = new ReportJDBCImpl();
        List<Expense> returnList = reportDAO.reportAllPending();

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

    public List<Expense> reportByExpDate(String date) {
        ReportDAO reportDAO = new ReportJDBCImpl();
        List<Expense> returnList = reportDAO.reportByExpDate(date);

        if (!returnList.isEmpty()) {
            return returnList;
        } else {
            return null;
        }
    }
}
