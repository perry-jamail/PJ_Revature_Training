import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number to search in the array for: ");
        int searchNum = Integer.parseInt(scan.next());

        linSearch(arr, searchNum);
    }

    public static int linSearch(int[] arr, int x) {
        for (int i = 0; i <= arr.length; i++) {
            if (x == arr[i]) {
                System.out.println("The search number " + x +
                        " was found at index " + i);
                return i;
            }
        }
        System.out.println("The search number " + x + " does not exist in the array.");
        return -1;
    }
}