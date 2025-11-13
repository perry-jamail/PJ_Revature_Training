// Sum of Elements: Calculate the sum of all elements in a 2D array.

public class Sum2D {
    static void main(String[] args) {
        int[][] twoD = {{1,2,3}, {4,5,6}, {7,8,9}};
        int sum = 0;

        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++) {
                sum += twoD[i][j];
            }
        }

        System.out.println(sum);
    }
}
