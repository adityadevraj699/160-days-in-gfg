import java.util.ArrayList;

class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        ArrayList<Integer> result = new ArrayList<>();

        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return result;
        }

        int n = mat.length;    // Number of rows
        int m = mat[0].length; // Number of columns

        // Define the boundaries
        int top = 0, bottom = n - 1, left = 0, right = m - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top boundary
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            top++;

            // Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--;

            // Traverse from right to left along the bottom boundary (if still valid)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left boundary (if still valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] mat1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int[][] mat2 = {
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18}
        };

        System.out.println(solution.spirallyTraverse(mat1)); // Expected: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
        System.out.println(solution.spirallyTraverse(mat2)); // Expected: [1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11]
    }
}
