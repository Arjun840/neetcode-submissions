class Solution {
    public int characterReplacement(String s, int k) {
        // Sliding window approach keep expanding window until
        // substring length - most freq char <= k 
        // once it exceeds this condition we msut shrink window
        // use hashmap to keep track of counts
        Map<Character, Integer> count = new HashMap<>();
        int res = 0; // result
        int l = 0; // left pointer
        int maxF = 0; // max frequency char
        for (int r = 0; r < s.length(); r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1); // count current char at r
            maxF = Math.max(maxF, count.get(s.charAt(r))); // update maxF so it will become 1 
            while ((r-l + 1) - maxF > k){ // Condition to shrink window
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1); // put char and count in map
                l++; // move the left pointer
            }
            res = Math.max(res, r - l + 1); 
        }
        return res;
    }
}
