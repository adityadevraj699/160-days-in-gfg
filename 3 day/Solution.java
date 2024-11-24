class Solution {
    public void reverseArray(int arr[]) {
        int temp;
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) { 
            // Swap the ith element with the (n-i-1)th element
            temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5};

        System.out.print("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        solution.reverseArray(arr);

        System.out.print("\nReversed array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
