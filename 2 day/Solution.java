class Solution {
    void pushZerosToEnd(int[] arr) {
        if (arr == null || arr.length == 0) {
            return; // Nothing to process if the array is empty or null.
        }

        int n = arr.length;
        int index = 0; // Pointer for placing non-zero elements.

        // Traverse the array and move non-zero elements to the front.
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }

        // Fill the remaining positions with zeros.
        while (index < n) {
            arr[index++] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] arr = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        solution.pushZerosToEnd(arr);

        System.out.print("Array after pushing zeroes to the end: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
