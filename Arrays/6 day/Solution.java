import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        // Step 1: Identify two potential candidates
        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Validate the candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        // Step 3: Return the result sorted in ascending order
        result.sort(Integer::compareTo);
        return result;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        System.out.println("Majority Elements: " + solution.findMajority(nums1)); // Output: [5, 6]

        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println("Majority Elements: " + solution.findMajority(nums2)); // Output: []

        // Test case 3
        int[] nums3 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println("Majority Elements: " + solution.findMajority(nums3)); // Output: [4]

        // Test case 4
        int[] nums4 = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println("Majority Elements: " + solution.findMajority(nums4)); // Output: [1, 2]
    }
}
