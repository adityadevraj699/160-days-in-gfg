import java.util.HashMap;

public class Solution {
    public static int countPairs(int[] arr, int target) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        // Traverse the array and count pairs
        for (int num : arr) {
            int complement = target - num;

            // If complement exists in the map, add its frequency to count
            if (freq.containsKey(complement)) {
                count += freq.get(complement);
            }

            // Add the current element to the frequency map
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 7, -1, 5};
        int target1 = 6;
        System.out.println("Output: " + countPairs(arr1, target1)); // Output: 3

        int[] arr2 = {1, 1, 1, 1};
        int target2 = 2;
        System.out.println("Output: " + countPairs(arr2, target2)); // Output: 6

        int[] arr3 = {10, 12, 10, 15, -1};
        int target3 = 125;
        System.out.println("Output: " + countPairs(arr3, target3)); // Output: 0
    }
}
