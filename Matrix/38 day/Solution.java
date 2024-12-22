class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int n = mat.length;      // Number of rows
        int m = mat[0].length;   // Number of columns
        
        int row = 0, col = m - 1; // Start from the top-right corner
        
        while (row < n && col >= 0) {
            if (mat[row][col] == x) {
                return true; // Element found
            } else if (mat[row][col] > x) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }
        return false; // Element not found
    }

    public static void main(String[] args) {
        int mat1[][] = {
            {3, 30, 38},
            {20, 52, 54},
            {35, 60, 69}
        };
        int x1 = 62;
        System.out.println(matSearch(mat1, x1)); // Output: false
        
        int mat2[][] = {
            {18, 21, 27},
            {38, 55, 67}
        };
        int x2 = 55;
        System.out.println(matSearch(mat2, x2)); // Output: true
        
        int mat3[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int x3 = 3;
        System.out.println(matSearch(mat3, x3)); // Output: true
    }
}
