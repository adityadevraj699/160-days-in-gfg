import java.util.HashMap;

class Solution {
    public int countSubarrays(int arr[], int k) {
        // Map to store the frequency of prefix sums
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int count = 0;
        int prefixSum = 0;

        // Initialize the prefix sum map with 0 as a key and 1 as its value
        prefixSumMap.put(0, 1);

        // Iterate through the array
        for (int num : arr) {
            // Update the current prefix sum
            prefixSum += num;

            // Check if (prefixSum - k) exists in the map
            if (prefixSumMap.containsKey(prefixSum - k)) {
                count += prefixSumMap.get(prefixSum - k);
            }

            // Update the map with the current prefix sum
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int arr1[] = {10, 2, -2, -20, 10};
        int k1 = -10;
        System.out.println("Output: " + solution.countSubarrays(arr1, k1));
        // Expected output: 3

        // Test case 2
        int arr2[] = {9, 4, 20, 3, 10, 5};
        int k2 = 33;
        System.out.println("Output: " + solution.countSubarrays(arr2, k2));
        // Expected output: 2

        // Test case 3
        int arr3[] = {1, 3, 5};
        int k3 = 0;
        System.out.println("Output: " + solution.countSubarrays(arr3, k3));
        // Expected output: 0
    }
}
