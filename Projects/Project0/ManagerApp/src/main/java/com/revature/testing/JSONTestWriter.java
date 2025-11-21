package com.revature.testing;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONTestWriter {
    static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = new String(Files.readAllBytes(Paths.get("C:\\Users\\perry\\Revature\\Projects\\Project0\\EmployeeApp\\expenses.json")));

        // Using JsonNodes
        JsonNode jsonNode = mapper.readTree(jsonString);
        System.out.println(jsonNode);
        JsonNode adminExpensesNode = jsonNode.get("admin");
        System.out.println(adminExpensesNode);
        JsonNode expense3Node = adminExpensesNode.get("expense7");
        System.out.println(expense3Node);
        ((ObjectNode) expense3Node).put("description", "This a new description for testing purposes.");
        System.out.println(expense3Node);

        ((ObjectNode) adminExpensesNode).set("expense7", expense3Node);
        ((ObjectNode) jsonNode).set("admin", adminExpensesNode);
        System.out.println(jsonNode);
        mapper.writeValue(new File("C:\\Users\\perry\\Revature\\Projects\\Project0\\EmployeeApp\\expenses.json"), (ObjectNode) jsonNode);
    }
}
