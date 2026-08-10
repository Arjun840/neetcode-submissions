class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> strMap = new HashMap<>();
        for (String s : strs){ // Loop through each string
            int[] count = new int[26];
            for (char c : s.toCharArray()){ // For each char, increment it's count in the array using ASCII value
                count[c - 'a']++;
            }
            String key = Arrays.toString(count); // The key will be a new string which is a combination of the counts "121" for ex.
            strMap.putIfAbsent(key, new ArrayList<>());
            strMap.get(key).add(s); // Add to map list
        }
        return new ArrayList<>(strMap.values()); // Return new list of values;
    }
}
