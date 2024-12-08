import java.util.*;

class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // List to store merged intervals
        List<int[]> mergedIntervals = new ArrayList<>();
        
        // Edge case: if the input is empty
        if (arr == null || arr.length == 0) {
            return mergedIntervals;
        }
        
        // Sort intervals by their start times
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Start with the first interval
        int[] currentInterval = arr[0];
        mergedIntervals.add(currentInterval);
        
        for (int[] interval : arr) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            
            // Check for overlap
            if (currentEnd >= nextStart) {
                // Merge intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add the interval to the list
                currentInterval = interval;
                mergedIntervals.add(currentInterval);
            }
        }
        
        return mergedIntervals;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int[][] arr1 = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        List<int[]> result1 = solution.mergeOverlap(arr1);
        System.out.println("Merged Intervals for Test Case 1:");
        for (int[] interval : result1) {
            System.out.println(Arrays.toString(interval));
        }
        
        // Test Case 2
        int[][] arr2 = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};
        List<int[]> result2 = solution.mergeOverlap(arr2);
        System.out.println("Merged Intervals for Test Case 2:");
        for (int[] interval : result2) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
