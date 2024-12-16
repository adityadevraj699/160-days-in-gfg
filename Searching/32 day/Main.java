class Solution {
    public int kthElement(int a[], int b[], int k) {
        int i = 0, j = 0, count = 0;
        int kth = 0;

        // Merge arrays until we find the k-th element
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                kth = a[i++];
            } else {
                kth = b[j++];
            }
            count++;
            if (count == k) return kth;
        }

        // If elements are left in array `a`
        while (i < a.length) {
            kth = a[i++];
            count++;
            if (count == k) return kth;
        }

        // If elements are left in array `b`
        while (j < b.length) {
            kth = b[j++];
            count++;
            if (count == k) return kth;
        }

        return -1; // k is out of bounds
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        System.out.println(solution.kthElement(a, b, 5)); // Output: 6

        int[] c = {1, 2, 3};
        int[] d = {4, 5, 6};
        System.out.println(solution.kthElement(c, d, 4)); // Output: 4

        int[] e = {};
        int[] f = {1, 2, 3};
        System.out.println(solution.kthElement(e, f, 2)); // Output: 2
    }
}
