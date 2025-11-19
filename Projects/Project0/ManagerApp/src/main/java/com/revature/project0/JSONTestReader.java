package com.revature.project0;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONTestReader {
    static void main(String[] args) throws IOException {
        // Reading test
        String jsonString = new String(Files.readAllBytes(Paths.get("expenses.json")));

        JSONObject jsonObject = new JSONObject(jsonString);
        System.out.println(jsonObject);

        JSONObject adminExpenses = jsonObject.getJSONObject("admin");
        System.out.println(adminExpenses);

        JSONObject individualExpense = adminExpenses.getJSONObject("expense3");
        System.out.println(individualExpense);

        // Writing test
        try (FileWriter file = new FileWriter("mydata.json")) {
            file.write(individualExpense);
        }
    }
}
