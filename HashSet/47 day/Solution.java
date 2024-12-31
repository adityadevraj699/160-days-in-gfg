import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] arr) {
        // Step 1: Handle the edge case for empty array
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // Step 2: Insert all elements into a HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // Step 3: Initialize maxLength to store the longest consecutive subsequence length
        int maxLength = 0;

        // Step 4: Iterate over the elements in the array
        for (int num : arr) {
            // Step 5: Check if this number is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Step 6: Count the length of the consecutive sequence starting with 'num'
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Step 7: Update the maximum length found
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        // Step 8: Return the result
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] arr1 = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(solution.longestConsecutive(arr1)); // Expected output: 6
        
        // Test case 2
        int[] arr2 = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(solution.longestConsecutive(arr2)); // Expected output: 4
        
        // Test case 3
        int[] arr3 = {15, 13, 12, 14, 11, 10, 9};
        System.out.println(solution.longestConsecutive(arr3)); // Expected output: 7
    }
}
