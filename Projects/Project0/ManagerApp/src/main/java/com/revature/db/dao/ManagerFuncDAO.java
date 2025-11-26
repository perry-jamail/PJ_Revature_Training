package com.revature.db.dao;

public interface ManagerFuncDAO {
    public void approvePending(int id, String username);
    public void denyPending(int id, String username);
}
