import java.util.ArrayList;

class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals that end before the newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge all overlapping intervals with the newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged interval
        result.add(newInterval);

        // Add all remaining intervals that start after the newInterval ends
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result;
    }

    // Helper method to print the result
    public static void printIntervals(ArrayList<int[]> intervals) {
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {4, 5}, {6, 7}, {8, 10}};
        int[] newInterval1 = {5, 6};
        ArrayList<int[]> result1 = insertInterval(intervals1, newInterval1);
        System.out.print("Output for Example 1: ");
        printIntervals(result1); // Expected: [[1,3], [4,7], [8,10]]

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 9};
        ArrayList<int[]> result2 = insertInterval(intervals2, newInterval2);
        System.out.print("Output for Example 2: ");
        printIntervals(result2); // Expected: [[1,2], [3,10], [12,16]]

        int[][] intervals3 = {};
        int[] newInterval3 = {5, 7};
        ArrayList<int[]> result3 = insertInterval(intervals3, newInterval3);
        System.out.print("Output for Example 3: ");
        printIntervals(result3); // Expected: [[5,7]]

        int[][] intervals4 = {{1, 2}, {3, 4}};
        int[] newInterval4 = {5, 6};
        ArrayList<int[]> result4 = insertInterval(intervals4, newInterval4);
        System.out.print("Output for Example 4: ");
        printIntervals(result4); // Expected: [[1,2], [3,4], [5,6]]

        int[][] intervals5 = {{1, 3}, {6, 9}};
        int[] newInterval5 = {2, 5};
        ArrayList<int[]> result5 = insertInterval(intervals5, newInterval5);
        System.out.print("Output for Example 5: ");
        printIntervals(result5); // Expected: [[1,5], [6,9]]
    }
}
