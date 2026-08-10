class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            while (charSet.contains(s.charAt(i))){
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(i));
            res = Math.max(i - l + 1, res);
        }
        return res;
    }
}
