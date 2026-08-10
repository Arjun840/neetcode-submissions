class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for (String str : strs){
            String[] strArr = new String[26];
            for (char c : str.toCharArray()){
                strArr[c - 'a'] += 1;
            }
            String key = Arrays.toString(strArr);
            strMap.putIfAbsent(key, new ArrayList<>());
            strMap.get(key).add(str);
        }
        return new ArrayList<>(strMap.values());
    }
}
