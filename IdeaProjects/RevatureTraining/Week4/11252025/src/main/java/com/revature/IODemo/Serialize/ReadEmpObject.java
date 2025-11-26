package com.revature.IODemo.Serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadEmpObject {

    static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("employee.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Employee emp = (Employee) objectInputStream.readObject();
            System.out.println(emp);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
