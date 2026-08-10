class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r; 
        // we binary search potential eating rates from 1 - max piles size;
        while (l <= r){
            int k = l + (r - l)/2;
            long time = 0;
            for (int p : piles){
                time += Math.ceil((double) p / k);
            }
            if (time <= h){ // we can still shrink the eating rate
                res = k;
                r = k - 1;
            } else{ // time is too small make it bigger
                l = k + 1;
            }
        }
        return res;
    }
}
