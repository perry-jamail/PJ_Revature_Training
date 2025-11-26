package com.revature.IODemo.Serialize;

import java.io.*;

public class WriteEmpObj {
    static void main(String[] args) {
        Employee employee1 = new Employee(101, "Harper", "Plano", "Engineer");
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;

        try {
            fileOutputStream = new FileOutputStream("employee.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
