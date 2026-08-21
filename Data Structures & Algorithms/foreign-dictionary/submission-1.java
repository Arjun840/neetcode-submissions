class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> adj = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();
      for (String word : words){
        for (char c : word.toCharArray()){
            adj.putIfAbsent(c, new HashSet<>());
            indegree.putIfAbsent(c, 0);
        }
      }
      
      for (int i = 0; i < words.length - 1; i++){
        String w1 = words[i];
        String w2 = words[i + 1];
        int minLen = Math.min(w1.length(), w2.length());
        if (w1.length() > w2.length() && w1.substring(0, minLen).equals
        (w2.substring(0, minLen))){
            return "";
        }
        // the lengths are valid up unitl this point
        for (int j = 0; j < minLen; j++){
            if (w1.charAt(j) != w2.charAt(j)){
                if (!adj.get(w1.charAt(j)).contains(w2.charAt(j))){ // check if w2 is already listed as an outgoing edge, if not we add it and then add another pre req to w2
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                }
                break;
            }
        }
      }
    Queue<Character> q = new LinkedList<>();
    for (char c : indegree.keySet()){
        if (indegree.get(c) == 0){
            q.offer(c);
        }
    }
    StringBuilder res = new StringBuilder();
    while (!q.isEmpty()){
        char char1 = q.poll();
        res.append(char1);
        for (char neighbor : adj.get(char1)){
            indegree.put(neighbor, indegree.get(neighbor) - 1);
            if (indegree.get(neighbor) == 0){
                q.offer(neighbor);
            }
        }
    }
    if (res.length() != indegree.size()){
        return "";
    }
    return res.toString();
    }
}
