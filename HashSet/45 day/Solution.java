import java.util.*;

class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // Use HashSet to store unique elements from both arrays
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        
        // Add elements from array a to setA
        for (int num : a) {
            setA.add(num);
        }
        
        // Find common elements and add them to resultSet
        for (int num : b) {
            if (setA.contains(num)) {
                resultSet.add(num);
            }
        }
        
        // Convert the HashSet to ArrayList
        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] a1 = {1, 2, 1, 3, 1};
        int[] b1 = {3, 1, 3, 4, 1};
        ArrayList<Integer> result1 = solution.intersectionWithDuplicates(a1, b1);
        System.out.println("Intersection: " + result1);
        
        // Example 2
        int[] a2 = {1, 1, 1};
        int[] b2 = {1, 1, 1, 1, 1};
        ArrayList<Integer> result2 = solution.intersectionWithDuplicates(a2, b2);
        System.out.println("Intersection: " + result2);
        
        // Example 3
        int[] a3 = {1, 2, 3};
        int[] b3 = {4, 5, 6};
        ArrayList<Integer> result3 = solution.intersectionWithDuplicates(a3, b3);
        System.out.println("Intersection: " + result3);
    }
}
