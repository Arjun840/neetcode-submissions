class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        Map<String, List<String>> nei = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList){
            for (int j = 0; j < word.length(); j++){
                String pattern = word.substring(0,j) + "*" + 
                word.substring(j + 1);
                nei.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }
        Set<String> visit = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int res = 1; // size of starting string
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){  // level traversal
                String word = q.poll(); // explore words on level
                if (word.equals(endWord)){ // if we find end word thats a solutiion path so return it
                    return res;
                }
                for (int j = 0; j < word.length(); j++){ // for every word on level, compute its patterns
                    String pattern = word.substring(0, j) + "*" + 
                    word.substring(j + 1);
                    for (String neiWord : nei.getOrDefault(pattern, Collections.emptyList())){ // for every pattern, iterate through neigjbor it can reach and add them to queue in next level
                        if (!visit.contains(neiWord)){
                            visit.add(neiWord);
                            q.offer(neiWord);
                        }
                    }
                }
            }
             res++;
        }
        return 0;
    }
}
