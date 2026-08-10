class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Use a map with the key being a 26 length integer with the
        // count of each char being present where the letter is in alphabet
        // Example: car would be 10100000000000100000000 or whatever
        // value is a list of strings, u add the string to the list if it has the same key
        // we'll then add these lists to a final list at the end
        // use array of size 26 then convert to string
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs){
            int[] countArray = new int[26];
            for (char c : str.toCharArray()){
                countArray[c - 'a']++;
            }
            String code = Arrays.toString(countArray);
            anagramMap.putIfAbsent(code, new ArrayList<>());
            anagramMap.get(code).add(str); // reference semantics no need to directly edit map
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : anagramMap.keySet()){
            res.add(anagramMap.get(key));
        }
        return res;
    }
}
