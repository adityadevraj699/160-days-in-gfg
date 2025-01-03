import java.util.HashMap;

class Solution {
    public long subarrayXor(int arr[], int k) {
        // Map to store the frequency of prefix XORs
        HashMap<Integer, Integer> xorMap = new HashMap<>();
        long count = 0;
        int prefixXor = 0;

        // Iterate through the array
        for (int num : arr) {
            // Update the current prefix XOR
            prefixXor ^= num;

            // Check if the prefix XOR itself equals k
            if (prefixXor == k) {
                count++;
            }

            // Check if (prefixXor ^ k) exists in the map
            int targetXor = prefixXor ^ k;
            if (xorMap.containsKey(targetXor)) {
                count += xorMap.get(targetXor);
            }

            // Update the map with the current prefix XOR
            xorMap.put(prefixXor, xorMap.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int arr1[] = {4, 2, 2, 6, 4};
        int k1 = 6;
        System.out.println("Output: " + solution.subarrayXor(arr1, k1));
        // Expected output: 4

        // Test case 2
        int arr2[] = {5, 6, 7, 8, 9};
        int k2 = 5;
        System.out.println("Output: " + solution.subarrayXor(arr2, k2));
        // Expected output: 2

        // Test case 3
        int arr3[] = {1, 1, 1, 1};
        int k3 = 0;
        System.out.println("Output: " + solution.subarrayXor(arr3, k3));
        // Expected output: 4
    }
}
