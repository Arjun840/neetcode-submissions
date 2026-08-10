class Solution {
    private Set<String> wordSet;
    private List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        backtrack(s, cur, 0);
        return res;
    }

    private void backtrack(String s, List<String> cur, int i){
        if (i == s.length()){
            res.add(String.join(" ", cur));
            return;
        }
        for (int j = i; j < s.length(); j++){
            String w = s.substring(i, j+1);
            if (wordSet.contains(w)){
                cur.add(w);
                backtrack(s,cur, j + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}