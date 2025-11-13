// Find Maximum/Minimum: Find the maximum or minimum element within a 2D array.

public class MaxMin {
    static void main(String[] args) {
        int[][] twoD = {{1,2,3}, {4,5,6}, {7,8,9}};
        int max = 0;
        int min = 10000;

        for (int[] ints : twoD) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] > max) {
                    max = ints[j];
                }

                if (ints[j] < min) {
                    min = ints[j];
                }
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
