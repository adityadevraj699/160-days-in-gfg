import java.util.*;

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];

        // Count citations in the bucket array
        for (int c : citations) {
            if (c >= n) {
                bucket[n]++;
            } else {
                bucket[c]++;
            }
        }

        // Calculate H-Index
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) {
                return i;
            }
        }

        return 0;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] citations1 = {3, 0, 5, 3, 0};
        System.out.println(sol.hIndex(citations1)); // Output: 3

        int[] citations2 = {5, 1, 2, 4, 1};
        System.out.println(sol.hIndex(citations2)); // Output: 2

        int[] citations3 = {0, 0};
        System.out.println(sol.hIndex(citations3)); // Output: 0
    }
}
