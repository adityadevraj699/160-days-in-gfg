class Solution {
    public int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;

        // If the array is not rotated (already sorted)
        if (arr[left] <= arr[right]) {
            return arr[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the minimum element
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }

            // Decide the search space
            if (arr[mid] >= arr[left]) {
                // Minimum must be in the right part
                left = mid + 1;
            } else {
                // Minimum must be in the left part
                right = mid;
            }
        }

        return arr[left]; // The minimum element
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] arr1 = {5, 6, 1, 2, 3, 4};
        System.out.println("Minimum: " + solution.findMin(arr1)); // Output: 1

        int[] arr2 = {3, 1, 2};
        System.out.println("Minimum: " + solution.findMin(arr2)); // Output: 1

        int[] arr3 = {4, 2, 3};
        System.out.println("Minimum: " + solution.findMin(arr3)); // Output: 2
    }
}
