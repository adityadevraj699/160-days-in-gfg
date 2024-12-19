import java.util.*;

class Solution {
    public int kthMissing(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        // Binary search to find where the kth missing number falls
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missingBeforeMid = arr[mid] - (mid + 1);

            if (missingBeforeMid < k) {
                left = mid + 1; // Missing numbers are less; move right
            } else {
                right = mid - 1; // Missing numbers are more; move left
            }
        }

        // At this point, 'left' is the index where kth missing falls
        return left + k;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        System.out.println(sol.kthMissing(new int[]{2, 3, 4, 7, 11}, 5)); // Output: 9
        System.out.println(sol.kthMissing(new int[]{1, 2, 3}, 2));        // Output: 5
        System.out.println(sol.kthMissing(new int[]{3, 5, 9, 10, 11, 12}, 2)); // Output: 2
    }
}
