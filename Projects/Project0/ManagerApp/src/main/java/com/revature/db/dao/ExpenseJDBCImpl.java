package com.revature.db.dao;

import com.revature.db.model.Expense;
import com.revature.db.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseJDBCImpl implements ExpenseDAO {
    Connection connection = null;
    Expense expenses = null;

    public Expense getExpense(int id) {
        connection = ConnectionUtil.dbConnection();
        String getExpense = "select * from expenses where expense_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getExpense);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                expenses = new Expense(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getFloat(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return expenses;
    }

    public List<Expense> getAllExpenses() {
        connection = ConnectionUtil.dbConnection();
        String getAllExpenses = "select * from expenses order by employee_id";
        List<Expense> expenseList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAllExpenses);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                expenses = new Expense(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getFloat(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10)
                );
                expenseList.add(expenses);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return expenseList;
    }

    public List<Expense> getAllPending() {
        connection = ConnectionUtil.dbConnection();
        List<Expense> fullList = getAllExpenses();
        List<Expense> pendingList = new ArrayList<>();

        for (Expense e : fullList) {
            if (e.getStatus().equalsIgnoreCase("Pending")) {
                pendingList.add(e);
            }
        }
        return pendingList;
    }

    public List<Expense> getAllApproved() {
        connection = ConnectionUtil.dbConnection();
        List<Expense> fullList = getAllExpenses();
        List<Expense> approvedList = new ArrayList<>();

        for (Expense e : fullList) {
            if (e.getStatus().equalsIgnoreCase("Approved")) {
                approvedList.add(e);
            }
        }
        return approvedList;
    }

    public void update(int id, String column, String value) {
        connection = ConnectionUtil.dbConnection();
        PreparedStatement preparedStatement = null;

        try {
            if (column.equalsIgnoreCase("amount")) {
                String updateA = "update expenses set amount = ? where expense_id = ?";
                preparedStatement = connection.prepareStatement(updateA);
                preparedStatement.setFloat(1, Float.parseFloat(value));
                preparedStatement.setInt(2, id);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) updated.");
            } else {
                preparedStatement = switch (column) {
                    case "manager_username" -> {
                        String updateMU = "update expenses set manager_username = ? where expense_id = ?";
                        yield connection.prepareStatement(updateMU);
                    }
                    case "name" -> {
                        String updateN = "update expenses set name = ? where expense_id = ?";
                        yield connection.prepareStatement(updateN);
                    }
                    case "amount" -> {
                        String updateA = "update expenses set amount = ? where expense_id = ?";
                        yield connection.prepareStatement(updateA);
                    }
                    case "category" -> {
                        String updateC = "update expenses set category = ? where expense_id = ?";
                        yield connection.prepareStatement(updateC);
                    }
                    case "status" -> {
                        String updateS = "update expenses set status = ? where expense_id = ?";
                        yield connection.prepareStatement(updateS);
                    }
                    case "description" -> {
                        String updateD = "update expenses set description = ? where expense_id = ?";
                        yield connection.prepareStatement(updateD);
                    }
                    case "manager_comment" -> {
                        String updateMC = "update expenses set manager_comment = ? where expense_id = ?";
                        yield connection.prepareStatement(updateMC);
                    }
                    default -> preparedStatement;
                };

                assert preparedStatement != null;
                preparedStatement.setString(1, value);
                preparedStatement.setInt(2, id);
                int rowsAffected = preparedStatement.executeUpdate();
//                System.out.println(rowsAffected + " row(s) updated.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        connection = ConnectionUtil.dbConnection();

        String deleteExpense = "delete from expenses where expense_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteExpense);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
