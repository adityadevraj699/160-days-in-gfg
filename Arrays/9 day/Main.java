import java.util.*;

class MinDiffSolution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        
        if (n == 1) return 0; // Single tower, no difference possible

        // Sort the array
        Arrays.sort(arr);

        // Initial maximum difference
        int diff = arr[n - 1] - arr[0];

        // Iterate through array and compute potential min/max heights
        for (int i = 1; i < n; i++) {
            // Ignore cases where subtracting k results in a negative height
            if (arr[i] < k) continue;

            // Minimum height among adjusted heights
            int minHeight = Math.min(arr[0] + k, arr[i] - k);
            // Maximum height among adjusted heights
            int maxHeight = Math.max(arr[n - 1] - k, arr[i - 1] + k);

            // Update the minimum difference
            diff = Math.min(diff, maxHeight - minHeight);
        }

        return diff;
    }
}

public class Main {
    public static void main(String[] args) {
        MinDiffSolution solution = new MinDiffSolution();

        // Test case 1
        int k1 = 2;
        int[] arr1 = {1, 5, 8, 10};
        System.out.println("Minimum difference: " + solution.getMinDiff(arr1, k1)); // Output: 5

        // Test case 2
        int k2 = 3;
        int[] arr2 = {3, 9, 12, 16, 20};
        System.out.println("Minimum difference: " + solution.getMinDiff(arr2, k2)); // Output: 11

        // Test case 3
        int k3 = 4;
        int[] arr3 = {7, 4, 8, 8, 8, 9};
        System.out.println("Minimum difference: " + solution.getMinDiff(arr3, k3)); // Output: 5

        // Test case 4 (Edge case with small values)
        int k4 = 2;
        int[] arr4 = {1, 2, 3};
        System.out.println("Minimum difference: " + solution.getMinDiff(arr4, k4)); // Output: 2

        // Test case 5 (Edge case with large values)
        int k5 = 1;
        int[] arr5 = {10000000, 10000001};
        System.out.println("Minimum difference: " + solution.getMinDiff(arr5, k5)); // Output: 1
    }
}
