class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // we'll be binary searching possible banana eating rates
        // it will be from 1 - largest pile in the piles[]
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = 0;

        while (l <= r){
            int k = l + (r-l)/2;
            long time = 0;
            for (int p : piles){ // for every piles in piles
                time += Math.ceil((double) p / k); // time to eat everything
            }
            if (time <= h){
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }
}
