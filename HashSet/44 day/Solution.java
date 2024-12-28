import java.util.*;

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // To store unique triplets
        Set<List<Integer>> resSet = new HashSet<>();
        int n = arr.length;

        // Map to store pairs of indices for a given sum
        Map<Integer, List<int[]>> mp = new HashMap<>();

        // Fill the map with all possible pairs and their sums
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                mp.putIfAbsent(sum, new ArrayList<>());
                mp.get(sum).add(new int[]{i, j});
            }
        }

        // Iterate through the array and look for complements
        for (int i = 0; i < n; i++) {
            int rem = -arr[i]; // Complement to find
            if (mp.containsKey(rem)) {
                List<int[]> pairs = mp.get(rem);
                for (int[] pair : pairs) {
                    // Ensure unique indices: i != pair[0] && i != pair[1]
                    if (pair[0] != i && pair[1] != i) {
                        List<Integer> curr = Arrays.asList(arr[i], arr[pair[0]], arr[pair[1]]);
                        Collections.sort(curr); // Sort values (not indices)
                        resSet.add(curr);
                    }
                }
            }
        }

        // Convert the set to a list and return
        return new ArrayList<>(resSet);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] arr1 = {0, -1, 2, -3, 1};
        System.out.println("Test Case 1: " + solution.findTriplets(arr1));

        // Test case 2
        int[] arr2 = {1, -2, 1, 0, 5};
        System.out.println("Test Case 2: " + solution.findTriplets(arr2));

        // Test case 3
        int[] arr3 = {2, 3, 1, 0, 5};
        System.out.println("Test Case 3: " + solution.findTriplets(arr3));

        // Additional test case
        int[] arr4 = {-5, 2, 3, 0, -3, 1};
        System.out.println("Additional Test Case: " + solution.findTriplets(arr4));
    }
}
