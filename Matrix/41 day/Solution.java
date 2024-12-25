class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length; // Number of rows
        int m = mat[0].length; // Number of columns

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if the first row needs to be zeroed
        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if the first column needs to be zeroed
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use the first row and column as markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0; // Mark the row
                    mat[0][j] = 0; // Mark the column
                }
            }
        }

        // Zero out cells based on markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // Handle the first row
        if (firstRowZero) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }

        // Handle the first column
        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }

    // Helper method to print the matrix (Optional, for testing)
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {
            {1, -1, 1},
            {-1, 0, 1},
            {1, -1, 1}
        };
        System.out.println("Original Matrix:");
        printMatrix(mat);

        solution.setMatrixZeroes(mat);

        System.out.println("Modified Matrix:");
        printMatrix(mat);
    }
}
