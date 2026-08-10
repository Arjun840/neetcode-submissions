class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Brute force could be sorting each string, and then utilizing 
        // a map, pairing the words that are the same
        Map<String, List<String>> strMap = new HashMap<>();
        for (String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            strMap.putIfAbsent(sortedS, new ArrayList<>());
            strMap.get(sortedS).add(s);
        }
        return new ArrayList<>(strMap.values());
    }
}
