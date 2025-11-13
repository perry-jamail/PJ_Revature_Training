// Row/Column Sums: Calculate the sum of elements for each individual row and each individual column
// in a 2D array.

public class RowColumnSums {
    static void main(String[] args) {
        int[][] twoD = {{1,2,3}, {4,5,6}, {7,8,9}};

        // Row sums
        for (int[] ints : twoD) {
            int rowSum = 0;
            for (int j = 0; j < ints.length; j++) {
                rowSum += ints[j];
            }
            System.out.println(rowSum);
        }
    }
}
