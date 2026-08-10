class Solution {
    public int maxProfit(int[] prices) {
        // Two pointer, left and right in consecutive indeces
        // If left value > right
        // Increment both
        // when right > left, this becomes the new profit unless its zero
        // keep checking with Math.max
        int l = 0;
        int r = 1;
        int profit = 0;
        while (r < prices.length){
            if (prices[l] < prices[r]){
                profit = Math.max(profit, prices[r] - prices[l]);
            } else{
                l = r;
            }
            r++;
        }
        return profit;
    }
}
