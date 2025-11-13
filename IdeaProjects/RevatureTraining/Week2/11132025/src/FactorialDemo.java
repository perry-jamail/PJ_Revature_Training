// Write a java function to calculate the factorial of a number. Accept input through Scanner.
// First do it through a normal for loop and then do it using a recursive function.

import java.util.Scanner;

public class FactorialDemo {
    static void main(String[] args) {
        System.out.println(scanFact());

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter an integer to find the factorial of: ");
        int inp = Integer.parseInt(scan.next());
        System.out.println(recursFact(inp));
    }

    static int scanFact() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter an integer to find the factorial of: ");
        int inp = Integer.parseInt(scan.next());

        int factorial = 1;
        for (int i = 1; i <= inp; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static int recursFact(int num) {
        if (num == 1 || num == 0) {
            return 1;
        }
        return num * recursFact(num - 1);
    }
}
