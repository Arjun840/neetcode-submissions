class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs){
            int[] charCount = new int[26];
            for (char c : s.toCharArray()){
                charCount[c - 'a']++;
            }
            String key = Arrays.toString(charCount);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
