package practice1;

import java.util.Scanner;

public class Calling {
    static void main(String[] args) {
        Functionality func = new Functionality();
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter two numbers to do math operations on: ");
        int num1 = Integer.parseInt(scan.next());
        int num2 = Integer.parseInt(scan.next());

        System.out.println(func.add(num1, num2));
        System.out.println(func.subtract(num1, num2));
        System.out.println(func.multiply(num1, num2));
        System.out.println(func.divide(num1, num2));
    }
}
