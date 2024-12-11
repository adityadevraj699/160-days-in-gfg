import java.util.Arrays;

class Solution {
    // Function to merge the arrays
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;

        // Start with pointers at the end of both arrays
        int i = n - 1;
        int j = 0;

        // Traverse both arrays and swap elements if needed
        while (i >= 0 && j < m) {
            if (a[i] > b[j]) {
                // Swap elements between a[i] and b[j]
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;

                // Move pointers
                i--;
                j++;
            } else {
                break;  // Arrays are already in order, no need to swap
            }
        }

        // Sort both arrays to ensure elements are in sorted order
        Arrays.sort(a);
        Arrays.sort(b);
    }

    // Function to print the arrays
    public void printArrays(int a[], int b[]) {
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : b) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] a1 = {2, 4, 7, 10};
        int[] b1 = {2, 3};
        sol.mergeArrays(a1, b1);
        sol.printArrays(a1, b1);

        int[] a2 = {1, 5, 9, 10, 15, 20};
        int[] b2 = {2, 3, 8, 13};
        sol.mergeArrays(a2, b2);
        sol.printArrays(a2, b2);

        int[] a3 = {0, 1};
        int[] b3 = {2, 3};
        sol.mergeArrays(a3, b3);
        sol.printArrays(a3, b3);
    }
}
