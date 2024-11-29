class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Rearrange the array using Cyclic Sort
        for (int i = 0; i < n; i++) {
            // Ensure the current number is within the valid range and not already in its correct position
            while (arr[i] >= 1 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            }
        }

        // Iterate through the rearranged array to find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1; // Found the missing number
            }
        }

        // If all numbers are in place, the smallest missing number is n + 1
        return n + 1;
    }

    // Swap function to swap two elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Driver code for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] arr1 = {2, -3, 4, 1, 1, 7};
        System.out.println("Smallest Missing Positive: " + solution.missingNumber(arr1)); // Output: 3

        // Test case 2
        int[] arr2 = {5, 3, 2, 5, 1};
        System.out.println("Smallest Missing Positive: " + solution.missingNumber(arr2)); // Output: 4

        // Test case 3
        int[] arr3 = {-8, 0, -1, -4, -3};
        System.out.println("Smallest Missing Positive: " + solution.missingNumber(arr3)); // Output: 1
    }
}
