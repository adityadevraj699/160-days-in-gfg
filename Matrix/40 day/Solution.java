class Solution {
    // Function to search a given number in a strictly sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // Get the number of rows and columns in the matrix
        int n = mat.length;    // Number of rows
        int m = mat[0].length; // Number of columns
        
        // Initialize binary search pointers
        int low = 0;
        int high = n * m - 1;
        
        // Perform binary search
        while (low <= high) {
            int mid = low + (high - low) / 2; // To prevent overflow
            int row = mid / m;               // Map mid to row
            int col = mid % m;               // Map mid to column
            
            if (mat[row][col] == x) {
                return true; // Found the element
            } else if (mat[row][col] < x) {
                low = mid + 1; // Move to the right half
            } else {
                high = mid - 1; // Move to the left half
            }
        }
        
        // If the loop ends, the element is not in the matrix
        return false;
    }
    
    // Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[][] mat1 = {{1, 5, 9}, {14, 20, 21}, {30, 34, 43}};
        int x1 = 14;
        System.out.println(solution.searchMatrix(mat1, x1)); // Output: true
        
        // Test case 2
        int[][] mat2 = {{1, 5, 9, 11}, {14, 20, 21, 26}, {30, 34, 43, 50}};
        int x2 = 42;
        System.out.println(solution.searchMatrix(mat2, x2)); // Output: false
        
        // Test case 3
        int[][] mat3 = {{87, 96, 99}, {101, 103, 111}};
        int x3 = 101;
        System.out.println(solution.searchMatrix(mat3, x3)); // Output: true
    }
}
