class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;

        // Step 1: Find the pivot
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find the smallest element larger than arr[i] from the right
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            // Step 3: Swap arr[i] and arr[j]
            swap(arr, i, j);
        }

        // Step 4: Reverse the suffix
        reverse(arr, i + 1, n - 1);
    }

    // Helper method to swap two elements in an array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Helper method to reverse a portion of the array
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3};

        System.out.print("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        solution.nextPermutation(arr);

        System.out.print("\nNext permutation: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
