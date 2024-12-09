import java.util.Arrays;

class Solution {
    static int minRemoval(int intervals[][]) {
        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int removals = 0; // Count of intervals to remove
        int lastEnd = Integer.MIN_VALUE; // End time of the last non-overlapping interval
        
        for (int[] interval : intervals) {
            if (interval[0] < lastEnd) {
                // Overlapping interval, count as removal
                removals++;
            } else {
                // Update the end time of the last included interval
                lastEnd = interval[1];
            }
        }
        
        return removals;
    }
    
    public static void main(String[] args) {
        // Example 1
        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(minRemoval(intervals1)); // Output: 1

        // Example 2
        int[][] intervals2 = {{1, 3}, {1, 3}, {1, 3}};
        System.out.println(minRemoval(intervals2)); // Output: 2

        // Example 3
        int[][] intervals3 = {{1, 2}, {5, 10}, {18, 35}, {40, 45}};
        System.out.println(minRemoval(intervals3)); // Output: 0
    }
}
