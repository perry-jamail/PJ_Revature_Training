import java.util.Scanner;

public class WhileProb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer to show the multiplication table of up to 10: ");
        int num = Integer.parseInt(scan.next());

        int count = 1;
        while (count <= 10) {
            System.out.println(count + " * " + num + " = " + (num * count));
            count += 1;
        }
    }
}
