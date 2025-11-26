package com.revature.IODemo;

import java.io.*;

public class FileStreamsDemo03 {
    static BufferedReader inputStream = null;
    static BufferedWriter outputStream = null;

    static void main(String[] args) {
        try {
            inputStream = new BufferedReader(new FileReader("example.txt"));
            outputStream = new BufferedWriter(new FileWriter("output3.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.write(l + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
