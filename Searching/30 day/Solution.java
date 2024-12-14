class Solution {
    public int search(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the key
            if (arr[mid] == key) {
                return mid;
            }

            // Check which part of the array is sorted
            if (arr[left] <= arr[mid]) {
                // Left half is sorted
                if (key >= arr[left] && key < arr[mid]) {
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1; // Search in the right half
                }
            } else {
                // Right half is sorted
                if (key > arr[mid] && key <= arr[right]) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
        }

        // Key not found
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key1 = 3;
        System.out.println("Index of " + key1 + ": " + solution.search(arr1, key1)); // Output: 8

        int[] arr2 = {3, 5, 1, 2};
        int key2 = 6;
        System.out.println("Index of " + key2 + ": " + solution.search(arr2, key2)); // Output: -1

        int[] arr3 = {33, 42, 72, 99};
        int key3 = 42;
        System.out.println("Index of " + key3 + ": " + solution.search(arr3, key3)); // Output: 1
    }
}
