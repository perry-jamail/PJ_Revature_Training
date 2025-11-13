// Write a program to add, subtract, multiply and divide two numbers using methods with parameters using only one class.

import java.util.Scanner;

public class prac1 {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the two numbers to perform the variety of math operations on: ");
        int num1 = Integer.parseInt(scan.next());
        int num2 = Integer.parseInt(scan.next());

        System.out.println(add(num1, num2));
        System.out.println(subtract(num1, num2));
        System.out.println(multiply(num1, num2));
        System.out.println(divide(num1, num2));
    }

    static int add(int num1, int num2) {
        return num1 + num2;
    }

    static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    static float divide(int num1, int num2) {
        return (float) num1 / num2;
    }
}
