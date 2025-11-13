// Print a 2D Array: Write a program to initialize and print the
// elements of a given 2D integer array (matrix).

public class Print2D {
    static void main(String[] args) {
        int[][] twoD = {{1,2,3}, {4,5,6}, {7,8,9}};
        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++) {
                if (j == twoD[i].length - 1) {
                    System.out.println(twoD[i][j]);
                } else {
                    System.out.print(twoD[i][j]);
                }
            }
        }
    }
}
