class Solution {
    public boolean isAnagram(String s, String t) {
        // Map the char counts for first string
        // For the second string, loop through string, and decrement counts
        // of each char
        // when a char reaches a count of 0, remove it
        // check if map is empty at end if it is, return true, if not false
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            countMap.putIfAbsent(s.charAt(i), 0);
            countMap.put(s.charAt(i), countMap.get(s.charAt(i)) + 1);
        }
    for (char c : t.toCharArray()){
        if (!countMap.containsKey(c)){
            return false;
        } else{
            if (countMap.get(c) == 1){
                countMap.remove(c);
            } else{
                countMap.put(c, countMap.get(c) - 1);
            }
        }
    }
    return countMap.isEmpty();
    }
}
