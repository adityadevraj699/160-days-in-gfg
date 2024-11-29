import java.util.Scanner;

class Solution {

    // Function to find the maximum circular subarray sum
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;

        // Step 1: Find the maximum subarray sum using Kadane's algorithm
        int maxKadane = kadane(arr);

        // Step 2: Find the total sum of the array and the minimum subarray sum
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i]; // Negate the elements for finding min subarray sum
        }

        // Min subarray sum is the negative of the max subarray sum of the negated array
        int minKadane = -kadane(arr);

        // Step 3: Compute the maximum circular subarray sum
        int circularSum = totalSum - minKadane;

        // Step 4: Handle edge case where all numbers are negative
        if (circularSum == 0) {
            return maxKadane;
        }

        // Return the maximum of maxKadane and circularSum
        return Math.max(maxKadane, circularSum);
    }

    // Helper function to compute maximum subarray sum using Kadane's algorithm
    private int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] arr1 = {8, -8, 9, -9, 10, -11, 12};
        System.out.println("Maximum Circular Subarray Sum: " + solution.circularSubarraySum(arr1)); // Output: 22

        // Example 2
        int[] arr2 = {10, -3, -4, 7, 6, 5, -4, -1};
        System.out.println("Maximum Circular Subarray Sum: " + solution.circularSubarraySum(arr2)); // Output: 23

        // Example 3
        int[] arr3 = {-1, 40, -14, 7, 6, 5, -4, -1};
        System.out.println("Maximum Circular Subarray Sum: " + solution.circularSubarraySum(arr3)); // Output: 52

        // Custom Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] customArr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            customArr[i] = scanner.nextInt();
        }
        System.out.println("Maximum Circular Subarray Sum: " + solution.circularSubarraySum(customArr));
        scanner.close();
    }
}
