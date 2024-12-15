class Solution {

    public int peakElement(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak
            boolean leftCondition = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean rightCondition = (mid == n - 1 || arr[mid] > arr[mid + 1]);

            if (leftCondition && rightCondition) {
                return mid;
            }

            // Move to the left subarray if the left neighbor is greater
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else {
                // Otherwise, move to the right subarray
                left = mid + 1;
            }
        }

        return -1; // This will never be reached due to problem constraints
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] arr1 = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(solution.peakElement(arr1)); // Output: Index of a peak (e.g., 5)

        // Test case 2
        int[] arr2 = {10, 20, 15, 2, 23, 90, 80};
        System.out.println(solution.peakElement(arr2)); // Output: Index of a peak (e.g., 1 or 5)

        // Test case 3
        int[] arr3 = {1, 2, 3};
        System.out.println(solution.peakElement(arr3)); // Output: Index of a peak (e.g., 2)

        // Test case 4
        int[] arr4 = {3, 2, 1};
        System.out.println(solution.peakElement(arr4)); // Output: Index of a peak (e.g., 0)
    }
}
