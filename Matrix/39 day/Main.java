
class Solution {
    // Function to search a given number in a row-wise sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        for (int[] row : mat) {
            // Use binary search on the current row.
            if (binarySearch(row, x)) {
                return true;
            }
        }
        return false;
    }

    // Helper function to perform binary search on a sorted array.
    private boolean binarySearch(int[] row, int x) {
        int left = 0, right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (row[mid] == x) {
                return true; // Element found.
            } else if (row[mid] < x) {
                left = mid + 1; // Search in the right half.
            } else {
                right = mid - 1; // Search in the left half.
            }
        }
        return false; // Element not found.
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[][] mat1 = {
            {3, 33, 72, 156, 175, 234, 313},
            {32, 96, 196, 199, 290, 348, 439},
            {23, 101, 155, 223, 261, 328, 417},
            {14, 88, 145, 193, 275, 311, 396},
            {13, 84, 115, 194, 253, 314, 327},
            {50, 83, 86, 141, 199, 254, 304},
            {32, 82, 168, 258, 285, 286, 321}
        };
        int x1 = 86;
        System.out.println(sol.searchRowMatrix(mat1, x1)); // Output: true

        // Test case 2
        int[][] mat2 = {
            {19, 22, 27, 38, 55, 67}
        };
        int x2 = 56;
        System.out.println(sol.searchRowMatrix(mat2, x2)); // Output: false

        // Test case 3
        int[][] mat3 = {
            {1, 2, 9},
            {65, 69, 75}
        };
        int x3 = 91;
        System.out.println(sol.searchRowMatrix(mat3, x3)); // Output: false

        // Test case 4
        int[][] mat4 = {
            {1, 3, 5},
            {7, 9, 11},
            {13, 15, 17}
        };
        int x4 = 7;
        System.out.println(sol.searchRowMatrix(mat4, x4)); // Output: true
    }
}
