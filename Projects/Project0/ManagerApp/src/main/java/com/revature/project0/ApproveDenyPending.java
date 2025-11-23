// Class for handling the approval of pending expenses with appropriate comments

package com.revature.project0;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ApproveDenyPending {
    // Method for approving or denying pending expenses
    public void approveDenyPending(String username) throws IOException {
        Logger logger = LoggerFactory.getLogger(ApproveDenyPending.class);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = new String(Files.readAllBytes(Paths.get("C:\\Users\\perry\\Revature\\Projects\\Project0\\EmployeeApp\\expenses.json")));
        Scanner scan = new Scanner(System.in);
        JsonNode fullExpenseList = mapper.readTree(jsonString);

        System.out.print("\nEnter the username of the employee whose expense you would like to approve or deny: ");
        String empUsername = scan.next();
        while (!fullExpenseList.has(empUsername)) {
            System.out.print("Invalid username. Check capitalization and try again: ");
            empUsername = scan.next();
        }
        JsonNode userExpenses = fullExpenseList.get(empUsername);

        System.out.print("Enter the ID of the pending expense you would like to approve or deny: ");
        String idToApproveDeny = scan.next();

        HashMap<String, JsonNode> pendingExpenses = new HashMap<String, JsonNode>();
        userExpenses.forEachEntry((key, value) -> {
            value.forEachEntry((iKey, iValue) -> {
                if (iValue.asText().equals("Pending")) {
                    pendingExpenses.put(key, value);
                }
            });
        });

        HashMap<String, JsonNode> expenseMatch = new HashMap<String, JsonNode>();
        for (Map.Entry<String, JsonNode> mapElement : pendingExpenses.entrySet()) {
            String key = mapElement.getKey();
            JsonNode value = mapElement.getValue();

            value.forEachEntry((iKey, iValue) -> {
                if (iKey.equals("id")) {
                    if (iValue.asText().equals(idToApproveDeny)) {
                        expenseMatch.put(key, value);
                    }
                }
            });
        }

        if (expenseMatch.isEmpty()) {
            System.out.println("Entered ID does not match any pending expense for '" + empUsername + "'.\n");
        } else {
            for (Map.Entry<String, JsonNode> mapElement : expenseMatch.entrySet()) {
                String key = mapElement.getKey();

                JsonNode expense = userExpenses.get(key);

                System.out.print("\nChoose one:\n\t(1) Approve Expense\n\t(2) Deny Expense\n> ");
                int ad = Integer.parseInt(scan.next());
                while (!(ad == 1 || ad == 2)) {
                    System.out.print("Invalid command. Enter (1) to Approve the expense or (2) to Deny the expense: ");
                    ad = Integer.parseInt(scan.next());
                }


                String managerComment = scan.nextLine();
                while (managerComment.isEmpty()) {
                    System.out.print("\nPlease enter the Manager Comment associated with this action: ");
                    managerComment = scan.nextLine();
                }

                if (ad == 1) {
                    ((ObjectNode) expense).put("status", "Approved");
                    logger.info("'{}' has approved '{}' submitted by '{}'.", username, key, empUsername);
                } else {
                    ((ObjectNode) expense).put("status", "Denied");
                    logger.info("'{}' has denied '{}' submitted by '{}'.", username, key, empUsername);
                }

                ((ObjectNode) expense).put("Manager Comment", (managerComment + " - '" + username + "'"));
                ((ObjectNode) userExpenses).set(key, expense);
                ((ObjectNode) fullExpenseList).set(empUsername, userExpenses);

                mapper.writeValue(new File("C:\\Users\\perry\\Revature\\Projects\\Project0\\EmployeeApp\\expenses.json"), (ObjectNode) fullExpenseList);
                System.out.println("\n'" + key + "' has been successfully updated with a new Status and Manager Comment.\n");
            }
        }
    }
}
