class Solution {
    
    // O(N): another approach by using Kadane's Algorithm
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length==0) {
            return 0;
        }
        
        int profit = 0;
        int currSum = 0;
        
        for (int i=1; i<prices.length; i++) {
            currSum += prices[i] - prices[i-1];
            currSum = Math.max(0, currSum);
            profit = Math.max(profit, currSum);
        }
        return profit;
    }
    
    // O(N)
    public int maxProfit_old(int[] prices) {
        if (prices == null || prices.length==0) {
            return 0;
        }
        
        int profit = 0;
        int min = prices[0];
        
        for (int i=1; i<prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;
    }
}