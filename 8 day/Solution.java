class Solution {
    public int maximumProfit(int prices[]) {
        int n = prices.length;
        if (n == 0) return 0;

        // Initialize variables to track the minimum price and maximum profit
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update the minimum price seen so far
            minPrice = Math.min(minPrice, price);
            // Calculate the profit if we sell at the current price
            int profit = price - minPrice;
            // Update the maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] prices1 = {7, 10, 1, 3, 6, 9, 2};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices1)); // Output: 8

        // Test case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices2)); // Output: 0

        // Test case 3
        int[] prices3 = {1, 3, 6, 9, 11};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices3)); // Output: 10

        // Test case 4
        int[] prices4 = {5, 5, 5, 5};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices4)); // Output: 0

        // Test case 5
        int[] prices5 = {1, 100};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices5)); // Output: 99
    }
}
