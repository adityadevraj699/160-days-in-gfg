import java.util.Arrays;

class Solution {
    // Function to rotate the matrix by 90 degrees in an anti-clockwise direction.
    static void rotateby90(int[][] mat) {
        int n = mat.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap mat[i][j] and mat[j][i]
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each column
        for (int j = 0; j < n; j++) {
            int top = 0, bottom = n - 1;
            while (top < bottom) {
                // Swap mat[top][j] and mat[bottom][j]
                int temp = mat[top][j];
                mat[top][j] = mat[bottom][j];
                mat[bottom][j] = temp;
                top++;
                bottom--;
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test Case 1
        int[][] mat1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(mat1);

        rotateby90(mat1);

        System.out.println("Rotated Matrix:");
        printMatrix(mat1);

        // Test Case 2
        int[][] mat2 = {
            {1, 2},
            {3, 4}
        };

        System.out.println("Original Matrix:");
        printMatrix(mat2);

        rotateby90(mat2);

        System.out.println("Rotated Matrix:");
        printMatrix(mat2);
    }

    // Helper method to print the matrix
    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}
