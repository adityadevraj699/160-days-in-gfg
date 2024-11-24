class Solution {
    public int maximumProfit(int prices[]) {
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            // If today's price is higher than yesterday's, sell for a profit
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] prices1 = {100, 180, 260, 310, 40, 535, 695};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices1)); // Output: 865

        // Test case 2
        int[] prices2 = {4, 2, 2, 2, 4};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices2)); // Output: 2

        // Test case 3
        int[] prices3 = {10, 20, 30, 40, 50};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices3)); // Output: 40

        // Test case 4
        int[] prices4 = {50, 40, 30, 20, 10};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices4)); // Output: 0

        // Test case 5
        int[] prices5 = {1, 7, 2, 3, 6, 7, 6, 7};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices5)); // Output: 12
    }
}
