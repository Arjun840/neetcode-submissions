class Solution {
    public int maxProfit(int[] prices) {
        // use two pointer approach
        // have the two pointers start next to each other
        // the smallest value u can find will be the best time to buy
        // if prices[l] > prices[r] expand window, l = r, r++
        // then keep calculating math.max while iterating r
        // calculate profit whenever l < r
        int l = 0;
        int r = 1;
        int maxP = 0;
        while (r < prices.length){
            if (prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else{
                l = r;
            }
            r++;
        }
        return maxP;
    }
}
