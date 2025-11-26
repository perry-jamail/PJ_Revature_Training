package com.revature.IODemo.JSONDemo;

import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class WritePersonObj {
    static void main(String[] args) {
        // 1. Create an instance of your Java object
        Person person = new Person("Amara", 0, "Frisco", "Texas");

        // 2. Create an ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        // 3. Define the output file
        File outputFile = new File("person.json");

        // 4. Write the object to the JSON file
        mapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, person);
        System.out.println("Object successfully written to person.json");
    }
}
