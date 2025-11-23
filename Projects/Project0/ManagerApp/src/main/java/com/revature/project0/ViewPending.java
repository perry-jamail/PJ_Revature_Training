// Class for handling the viewing of all pending expenses by employees

package com.revature.project0;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ViewPending {
    // Method to pull full expense list and print a list of only the pending expenses among the full list
    public void viewAllPendingExpenses() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = new String(Files.readAllBytes(Paths.get("C:\\Users\\perry\\Revature\\Projects\\Project0\\EmployeeApp\\expenses.json")));
        JsonNode fullExpenseList = mapper.readTree(jsonString);

        fullExpenseList.forEachEntry((key, value) -> {
            value.forEachEntry((uKey, uValue) -> {
                uValue.forEachEntry((eKey, eValue) -> {
                    if (eValue.asText().equals("Pending")) {
                        System.out.println("Expense Name: '" + uKey + "'\nExpense Data: " + uValue +
                                "\nSubmitted by employee user: '" + key + "'\n");
                    }
                });
            });
        });
    }
}
