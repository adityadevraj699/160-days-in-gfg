import java.util.HashSet;

class Solution {
    public static int findUnion(int a[], int b[]) {
        // Create a HashSet to store unique elements
        HashSet<Integer> unionSet = new HashSet<>();

        // Add elements of the first array to the HashSet
        for (int num : a) {
            unionSet.add(num);
        }

        // Add elements of the second array to the HashSet
        for (int num : b) {
            unionSet.add(num);
        }

        // Return the size of the HashSet, which represents the union count
        return unionSet.size();
    }
}

public class UnionofArrays {
    public static void main(String[] args) {
        // Test Case 1
        int[] a1 = {1, 2, 3, 4, 5};
        int[] b1 = {1, 2, 3};
        System.out.println("Union Count: " + Solution.findUnion(a1, b1)); // Output: 5

        // Test Case 2
        int[] a2 = {85, 25, 1, 32, 54, 6};
        int[] b2 = {85, 2};
        System.out.println("Union Count: " + Solution.findUnion(a2, b2)); // Output: 7

        // Test Case 3
        int[] a3 = {1, 2, 1, 1, 2};
        int[] b3 = {2, 2, 1, 2, 1};
        System.out.println("Union Count: " + Solution.findUnion(a3, b3)); // Output: 2
    }
}


