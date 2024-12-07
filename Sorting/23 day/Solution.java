class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        if (arr == null || arr.length < 2) return 0;
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    // Recursive function to implement merge sort and count inversions.
    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Count inversions in left half.
            count += mergeSortAndCount(arr, left, mid);

            // Count inversions in right half.
            count += mergeSortAndCount(arr, mid + 1, right);

            // Count inversions during merging.
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    // Merge two sorted halves of the array and count inversions.
    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        // Fill left and right subarrays.
        System.arraycopy(arr, left, leftArr, 0, mid - left + 1);
        System.arraycopy(arr, mid + 1, rightArr, 0, right - mid);

        int i = 0, j = 0, k = left, swaps = 0;

        // Merge the two subarrays and count inversions.
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                // Count the inversions: all remaining elements in leftArr are greater.
                swaps += (leftArr.length - i);
            }
        }

        // Copy remaining elements of leftArr (if any).
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of rightArr (if any).
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        return swaps;
    }

    // Driver code to test the function.
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println("Inversion count: " + inversionCount(arr));
    }
}
