class Solution {
    // Edge case is that if the strings are diff lengths
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s == null || t == null){
            return false;
        }
        Map<String, Integer> sMap = new HashMap<>();
        Map<String, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){ // Populate maps
            String letter = s.substring(i, i+1);
            if (!sMap.containsKey(letter)){
                sMap.put(letter, 1);
            } else{
                sMap.put(letter, sMap.get(letter)+1);
            }
        }
        for (int i = 0; i < t.length(); i++){
            String letter = t.substring(i, i+1);
            if (!tMap.containsKey(letter)){
                tMap.put(letter, 1);
            } else{
                tMap.put(letter, tMap.get(letter)+1);
            }
        }
        for (String c : sMap.keySet()){
            if (!sMap.get(c).equals(tMap.get(c))){
                return false;
            }
        }
        return true;
    }
}
