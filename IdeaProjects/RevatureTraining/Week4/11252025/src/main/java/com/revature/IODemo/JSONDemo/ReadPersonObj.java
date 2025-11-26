package com.revature.IODemo.JSONDemo;

import tools.jackson.databind.ObjectMapper;

import java.io.*;

public class ReadPersonObj {
    static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("people.json"); // Replace with your file path

        Person person = objectMapper.readValue(jsonFile, Person.class);
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("City: " + person.getCity());
        System.out.println("State: " + person.getState());
    }
}
