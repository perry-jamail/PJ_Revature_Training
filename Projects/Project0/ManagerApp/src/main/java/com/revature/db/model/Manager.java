package com.revature.db.model;

public class Manager {
    private int manager_id;
    private String username;
    private String password;

    public Manager(){
    }

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Manager(int manager_id, String username, String password) {
        this.manager_id = manager_id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manager_id=" + manager_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getManager_id() {
        return manager_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
