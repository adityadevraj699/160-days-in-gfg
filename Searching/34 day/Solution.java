class Solution {
    public static int findPages(int[] arr, int k) {
        // Edge case: Not enough books for the students
        if (k > arr.length) {
            return -1;
        }

        // Find the range for binary search
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages); // Maximum single book pages
            high += pages;             // Total sum of all pages
        }

        int result = -1;

        // Binary search for the minimum maximum pages
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(arr, k, mid)) {
                result = mid; // Update the result
                high = mid - 1; // Try for a smaller value
            } else {
                low = mid + 1; // Increase the pages limit
            }
        }

        return result;
    }

    private static boolean isFeasible(int[] arr, int k, int maxPages) {
        int studentsRequired = 1; // Start with one student
        int currentSum = 0;

        for (int pages : arr) {
            if (currentSum + pages > maxPages) {
                // Assign books to the next student
                studentsRequired++;
                currentSum = pages;

                // If more students are needed than available, return false
                if (studentsRequired > k) {
                    return false;
                }
            } else {
                currentSum += pages;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {12, 34, 67, 90};
        int k1 = 2;
        System.out.println(findPages(arr1, k1)); // Output: 113

        // Example 2
        int[] arr2 = {15, 17, 20};
        int k2 = 5;
        System.out.println(findPages(arr2, k2)); // Output: -1

        // Example 3
        int[] arr3 = {22, 23, 67};
        int k3 = 1;
        System.out.println(findPages(arr3, k3)); // Output: 112
    }
}
