package com.revature.db;

import com.revature.db.service.ManagerFuncService;
import com.revature.db.service.ManagerFuncServiceImpl;

import java.util.Scanner;

public class ApproveDeny {
    public void managerFuncOptions(String username) {
        Scanner scan = new Scanner(System.in);
        ManagerFuncService managerFuncService = new ManagerFuncServiceImpl();

        System.out.print("\nChoose one:\n\t1) Approve Pending Expense\n\t2) Deny Pending Expense\n\t" +
                "h) Return to Home Screen\n> ");
        String manFuncOp = scan.next();

        switch (manFuncOp) {
            case "1":
                System.out.print("\nEnter the ID of the pending expense to approve: ");
                int idToApprove = Integer.parseInt(scan.next());
                managerFuncService.approvePending(idToApprove, username);
                break;
            case "2":
                System.out.print("\nEnter the ID of the pending expense to deny: ");
                int idToDeny = Integer.parseInt(scan.next());
                managerFuncService.denyPending(idToDeny, username);
                break;
            case "h":
                System.out.println("Returning to home screen...\n");
                break;
            default:
                System.out.println("Invalid input. Please enter a number between 1-3, or 'h'.");
                managerFuncOptions(username);
        }
    }
}
