class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char currS = s.charAt(i);
            char currT = t.charAt(i);
            sMap.putIfAbsent(currS, 0);
            tMap.putIfAbsent(currT, 0);
            sMap.put(currS, sMap.get(currS) + 1);
            tMap.put(currT, tMap.get(currT) + 1);
        }
        
        return tMap.equals(sMap);
    }
}
