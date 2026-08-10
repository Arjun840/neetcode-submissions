class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            sCount.putIfAbsent(s.charAt(i), 0);
            sCount.put(s.charAt(i), sCount.get(s.charAt(i)) + 1);
            tCount.putIfAbsent(t.charAt(i), 0);
            tCount.put(t.charAt(i), tCount.get(t.charAt(i)) + 1);
        }
        return sCount.equals(tCount);
}
}
