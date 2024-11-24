// Class containing the solution
class Solution {

    // Function to find the sum of contiguous subarray with the maximum sum.
    int maxSubarraySum(int[] arr) {
        // Initialize variables
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Include the current element in the subarray
            max_ending_here += arr[i];

            // Update max_so_far if max_ending_here is greater
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }

            // Reset max_ending_here to 0 if it becomes negative
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }

        return max_so_far;
    }
}

// Main class to test the solution
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] arr1 = {2, 3, -8, 7, -1, 2, 3};
        int[] arr2 = {-2, -4};
        int[] arr3 = {5, 4, 1, 7, 8};

        // Display results
        System.out.println("Maximum sum of subarray in arr1: " + solution.maxSubarraySum(arr1)); // Output: 11
        System.out.println("Maximum sum of subarray in arr2: " + solution.maxSubarraySum(arr2)); // Output: -2
        System.out.println("Maximum sum of subarray in arr3: " + solution.maxSubarraySum(arr3)); // Output: 25
    }
}
