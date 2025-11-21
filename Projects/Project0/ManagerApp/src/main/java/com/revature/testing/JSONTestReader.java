package com.revature.testing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class JSONTestReader {
    static void main(String[] args) throws IOException {
        // Reading test
        // Reads JSON file as a String
        String jsonString = new String(Files.readAllBytes(Paths.get("expenses.json")));

        // Turns the String of the JSON file into a JSONObject
        JSONObject jsonObject = new JSONObject(jsonString);
        System.out.println(jsonObject);

        // Creates a new JSONObject with only the specified key and subdictionary
        JSONObject adminExpenses = jsonObject.getJSONObject("admin");
        System.out.println(adminExpenses);

        // Creates a new JSONObject with only the specified key and subdictionary
        JSONObject individualExpense = adminExpenses.getJSONObject("expense3");
        System.out.println(individualExpense);

        // Turns the JSONObject into a String
        String indExpString = String.valueOf(individualExpense);
        System.out.println(indExpString);

        // Turns the String into a HashMap<String, String>
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, String>> typeref = new TypeReference<HashMap<String, String>>() {};
        HashMap<String, String> o = mapper.readValue(indExpString, typeref);
        for (Map.Entry<String, String> mapElement : o.entrySet()) {
            String key = mapElement.getKey();
            String value = mapElement.getValue();
            System.out.println(key + ": " + value);
        }
        System.out.println(o);

        // Writing test
        // Loops through the HashMap<String, String> and adds the key/value pairs to an ObjectNode
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonNode = objectMapper.createObjectNode();
        for (Map.Entry<String, String> mapElement : o.entrySet()) {
            String key = mapElement.getKey();
            String value = mapElement.getValue();

            if (key.equals("description")) {
                value = "This is a new description.";
            }

            jsonNode.put(key, value);
        }
        // That ObjectNode is then written to a JSON file.
        objectMapper.writeValue(new File("mydata.json"), jsonNode);
    }
}
