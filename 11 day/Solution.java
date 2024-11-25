class Solution {
    // Function to find the maximum product subarray
    public int maxProduct(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int maxProduct = arr[0];
        int currentMax = arr[0];
        int currentMin = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // If the current element is negative, swap currentMax and currentMin
            if (arr[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            // Update currentMax and currentMin
            currentMax = Math.max(arr[i], currentMax * arr[i]);
            currentMin = Math.min(arr[i], currentMin * arr[i]);

            // Update maxProduct
            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {-2, 6, -3, -10, 0, 2};
        System.out.println("Maximum Product Subarray: " + solution.maxProduct(arr1)); // Output: 180

        int[] arr2 = {-1, -3, -10, 0, 60};
        System.out.println("Maximum Product Subarray: " + solution.maxProduct(arr2)); // Output: 60

        int[] arr3 = {2, 3, 4};
        System.out.println("Maximum Product Subarray: " + solution.maxProduct(arr3)); // Output: 24
    }
}
