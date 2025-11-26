package com.revature.db.service;

public interface ManagerFuncService {
    public void approvePending(int id, String username);
    public void denyPending(int id, String username);
}
