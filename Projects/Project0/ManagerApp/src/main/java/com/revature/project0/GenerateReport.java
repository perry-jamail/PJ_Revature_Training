// Class for handling the generation of spending reports based on employee, category, or date.

package com.revature.project0;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class GenerateReport {
    String username;
    Scanner scan = new Scanner(System.in);
    ObjectMapper mapper = new ObjectMapper();
    String jsonString;
    JsonNode fullExpenseList;
    Logger logger = LoggerFactory.getLogger(GenerateReport.class);

    public void reportOptions(String username) throws IOException {
        this.username = username;
        this.jsonString = new String(Files.readAllBytes(Paths.get("C:\\Users\\perry\\Revature\\Projects\\Project0\\EmployeeApp\\expenses.json")));
        this.fullExpenseList = mapper.readTree(jsonString);

        System.out.print("\nGenerate report based on:\n\t1) All Approved Expenses" + "\n\t2) Employee Username" +
                "\n\t3) Expense Category\n\t4) Expense Submission Date\n\th) Return to Home Screen\n> ");
        String repOp = scan.next();

        if (repOp.equals("1")) {
            reportAllApproved();
        } else if (repOp.equals("2")) {
            reportByEmpUsername();
        } else if (repOp.equals("3")) {
            reportByExpCategory();
        } else if (repOp.equals("4")) {
            reportByExpDate();
        } else if (repOp.equalsIgnoreCase("h")) {
            System.out.println("Returning to home screen...\n");
        } else {
            System.out.println("Invalid input. Please enter a number between 1-3.");
            reportOptions(username);
        }
    }

    public void reportAllApproved() {
        System.out.println("\n*************************** Report Results ***************************");
        fullExpenseList.forEachEntry((key, value) -> {
            value.forEachEntry((uKey, uValue) -> {
                uValue.forEachEntry((eKey, eValue) -> {
                    if (eKey.equalsIgnoreCase("status")) {
                        if (eValue.asText().equalsIgnoreCase("Approved")) {
                            System.out.println("Expense Name: '" + uKey + "'\nExpense Data: " + uValue +
                                    "\nSubmitted by employee user: '" + key + "'\n");
                        }
                    }
                });
            });
        });
        System.out.println("*************************** End of Report ***************************\n");
        logger.info("'{}' generated an approved expenses report of all approved expenses.", username);
    }

    public void reportByEmpUsername() {
        System.out.print("\nEnter the EMPLOYEE USERNAME for the employee you would like to generate a report of all Approved expenses for: > ");
        String empUsername = scan.next();
        while (!fullExpenseList.has(empUsername)) {
            System.out.print("Invalid username. Check capitalization and try again: ");
            empUsername = scan.next();
        }

        System.out.println("\n*************************** Report Results ***************************");
        JsonNode userExpenses = fullExpenseList.get(empUsername);
        userExpenses.forEachEntry((key, value) -> {
            value.forEachEntry((iKey, iValue) -> {
                if (iValue.asText().equalsIgnoreCase("Approved")) {
                    System.out.println("Expense Name: '" + key + "'\nExpense Data: " + value + "\n");
                }
            });
        });
        System.out.println("*************************** End of Report ***************************\n");
        logger.info("'{}' generated an approved expenses report by employee username '{}'.", username, empUsername);
    }

    public void reportByExpCategory() {
        System.out.print("\nEnter the EXPENSE CATEGORY you would like to generate a report of all Approved expenses for: > ");
        String searchCategory = scan.next();

        System.out.println("\n*************************** Report Results ***************************");
        fullExpenseList.forEachEntry((key, value) -> {
            value.forEachEntry((uKey, uValue) -> {
                uValue.forEachEntry((eKey, eValue) -> {
                    if (eKey.equalsIgnoreCase("category")) {
                        if (eValue.asText().equalsIgnoreCase(searchCategory)) {
                            System.out.println("Expense Name: '" + uKey + "'\nExpense Data: " + uValue +
                                    "\nSubmitted by employee user: '" + key + "'\n");
                        }
                    }
                });
            });
        });
        System.out.println("*************************** End of Report ***************************\n");
        logger.info("'{}' generated an approved expenses report by category '{}'.", username, searchCategory);
    }

    public void reportByExpDate() {
        System.out.print("\nEnter the EXPENSE ENTRY DATE you would like to generate a report of all Approved expenses for (YYYY-MM-DD): > ");
        String searchCategory = scan.next();

        System.out.println("\n*************************** Report Results ***************************");
        fullExpenseList.forEachEntry((key, value) -> {
            value.forEachEntry((uKey, uValue) -> {
                uValue.forEachEntry((eKey, eValue) -> {
                    boolean approved = false;
                    if (eKey.equalsIgnoreCase("status")) {
                        if (eValue.asText().equalsIgnoreCase("Approved")) {
                            approved = true;
                        }
                    }

                    if (approved) {
                        uValue.forEachEntry((aKey, aValue) -> {
                            if (aKey.equalsIgnoreCase("date")) {
                                if (aValue.asText().equalsIgnoreCase(searchCategory)) {
                                    System.out.println("Expense Name: '" + uKey + "'\nExpense Data: " + uValue +
                                            "\nSubmitted by employee user: '" + key + "'\n");
                                }
                            }
                        });
                    }
                });
            });
        });
        System.out.println("*************************** End of Report ***************************\n");
        logger.info("'{}' generated an approved expenses report by expense date '{}'.", username, searchCategory);
    }
}
