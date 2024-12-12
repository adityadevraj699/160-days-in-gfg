class Solution {
    // Main method to count the frequency of the target
    int countFreq(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        if (first == -1) {
            // Target is not present in the array
            return 0;
        }
        int last = findLastOccurrence(arr, target);
        return last - first + 1;
    }

    // Function to find the first occurrence of the target
    int findFirstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid; // Record the index
                high = mid - 1; // Move to the left half
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Function to find the last occurrence of the target
    int findLastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid; // Record the index
                low = mid + 1; // Move to the right half
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {1, 1, 2, 2, 2, 2, 3};
        int target1 = 2;
        System.out.println("Occurrences of " + target1 + ": " + solution.countFreq(arr1, target1)); // Output: 4

        int[] arr2 = {1, 1, 2, 2, 2, 2, 3};
        int target2 = 4;
        System.out.println("Occurrences of " + target2 + ": " + solution.countFreq(arr2, target2)); // Output: 0

        int[] arr3 = {8, 9, 10, 12, 12, 12};
        int target3 = 12;
        System.out.println("Occurrences of " + target3 + ": " + solution.countFreq(arr3, target3)); // Output: 3
    }
}