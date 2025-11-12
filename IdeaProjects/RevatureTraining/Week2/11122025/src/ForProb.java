import java.util.Scanner;

public class ForProb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer to determine how many rows the staircase will have: ");
        int num = Integer.parseInt(scan.next());

        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    System.out.println("*");
                } else {
                    System.out.print("*");
                }
            }
        }

        for (int i = num; i >= 0; i--) {
            for (int j = 2; j <= i; j++) {
                if (j == i) {
                    System.out.println("*");
                } else {
                    System.out.print("*");
                }
            }
        }
    }
}
