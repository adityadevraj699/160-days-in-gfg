import java.util.Arrays;

class Solution {
    // Main function to find the largest minimum distance
    public static int aggressiveCows(int[] stalls, int k) {
        // Step 1: Sort the stalls to arrange them in ascending order
        Arrays.sort(stalls);

        int n = stalls.length;
        int low = 1; // Minimum possible distance
        int high = stalls[n - 1] - stalls[0]; // Maximum possible distance
        int result = 0; // To store the final result for the largest minimum distance

        // Step 2: Apply Binary Search on the possible distance range
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the mid-point of the current range

            // Check if the current mid distance is feasible
            if (isFeasible(stalls, k, mid)) {
                result = mid; // Update the result since this distance is feasible
                low = mid + 1; // Try for a larger distance
            } else {
                high = mid - 1; // Try for a smaller distance
            }
        }
        return result; // Return the largest minimum distance found
    }

    // Helper function to check if placing cows with at least 'distance' apart is feasible
    private static boolean isFeasible(int[] stalls, int k, int distance) {
        int count = 1; // Place the first cow at the first stall
        int lastPosition = stalls[0]; // Keep track of the last position where a cow was placed

        // Iterate over the stalls to place the remaining cows
        for (int i = 1; i < stalls.length; i++) {
            // Check if the current stall is at least 'distance' away from the last placed cow
            if (stalls[i] - lastPosition >= distance) {
                count++; // Place a cow here
                lastPosition = stalls[i]; // Update the last position

                // If all cows are placed, return true
                if (count == k) {
                    return true;
                }
            }
        }
        // If not all cows can be placed, return false
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1
        int[] stalls1 = {1, 2, 4, 8, 9};
        int k1 = 3;
        System.out.println("Largest Minimum Distance: " + aggressiveCows(stalls1, k1)); // Output: 3

        // Example 2
        int[] stalls2 = {10, 1, 2, 7, 5};
        int k2 = 3;
        System.out.println("Largest Minimum Distance: " + aggressiveCows(stalls2, k2)); // Output: 4

        // Example 3
        int[] stalls3 = {2, 12, 11, 3, 26, 7};
        int k3 = 5;
        System.out.println("Largest Minimum Distance: " + aggressiveCows(stalls3, k3)); // Output: 1
    }
}
