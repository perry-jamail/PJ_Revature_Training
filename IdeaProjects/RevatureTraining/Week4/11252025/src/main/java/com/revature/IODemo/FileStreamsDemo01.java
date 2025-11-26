package com.revature.IODemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamsDemo01 {
    static FileInputStream fileInputStream;
    static FileOutputStream fileOutputStream;

    static void main(String[] args) {
        try {
            fileInputStream = new FileInputStream("example.txt");
            fileOutputStream = new FileOutputStream("output1.txt");
            int o;
//            o = fileInputStream.read();

            while ((o = fileInputStream.read()) != -1) {
                fileOutputStream.write(o);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
