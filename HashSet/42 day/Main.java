import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] arr1 = {1, 4, 45, 6, 10, 8};
        int target1 = 16;
        System.out.println(solution.twoSum(arr1, target1)); // Output: true

        // Test case 2
        int[] arr2 = {1, 2, 4, 3, 6};
        int target2 = 11;
        System.out.println(solution.twoSum(arr2, target2)); // Output: false

        // Test case 3
        int[] arr3 = {11};
        int target3 = 11;
        System.out.println(solution.twoSum(arr3, target3)); // Output: false
    }
}

class Solution {
    boolean twoSum(int[] arr, int target) {
        // Create a HashSet to store numbers
        HashSet<Integer> set = new HashSet<>();

        // Iterate through the array
        for (int num : arr) {
            // Calculate the remaining value needed for the sum
            int rem = target - num;

            // Check if the remainder exists in the set
            if (set.contains(rem)) {
                return true;
            }

            // Add the current number to the set
            set.add(num);
        }

        // If no pair is found, return false
        return false;
    }
}
