package com.revature.db.model;

import java.util.Date;

public class Expense {
    private int id;
    private int employee_id;
    private String manager_username;
    private String name;
    private String submission_date;
    private float amount;
    private String category;
    private String status;
    private String description;
    private String manager_comment;

    public Expense() {

    }

    public Expense(int employee_id, String manager_username, String name, String submission_date, float amount, String category, String status, String description, String manager_comment) {
        this.employee_id = employee_id;
        this.manager_username = manager_username;
        this.name = name;
        this.submission_date = submission_date;
        this.amount = amount;
        this.category = category;
        this.status = status;
        this.description = description;
        this.manager_comment = manager_comment;
    }

    public Expense(int employee_id, String name, String submission_date, float amount, String category, String description) {
        this.employee_id = employee_id;
        this.name = name;
        this.submission_date = submission_date;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.status = "Pending";
    }

    public Expense(int id, int employee_id, String manager_username, String name, String submission_date, float amount, String category, String status, String description, String manager_comment) {
        this.id = id;
        this.employee_id = employee_id;
        this.manager_username = manager_username;
        this.name = name;
        this.submission_date = submission_date;
        this.amount = amount;
        this.category = category;
        this.status = status;
        this.description = description;
        this.manager_comment = manager_comment;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", employee_id=" + employee_id +
                ", manager_username='" + manager_username + '\'' +
                ", name='" + name + '\'' +
                ", submission_date=" + submission_date +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", manager_comment='" + manager_comment + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public String getSubmission_date() {
        return submission_date;
    }

    public String getManager_username() {
        return manager_username;
    }

    public void setManager_username(String manager_username) {
        this.manager_username = manager_username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManager_comment() {
        return manager_comment;
    }

    public void setManager_comment(String manager_comment) {
        this.manager_comment = manager_comment;
    }
}
