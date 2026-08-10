class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>()); // there should be n-1 nodes in the adj list 
        }
        for (int[] edge : edges){ // for every edge
            adj.get(edge[0]).add(edge[1]); // add edge to first
            adj.get(edge[1]).add(edge[0]); // add edge to second
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            if (!visit[i]){
                dfs(i, adj, visit);
                res++;
            }
        }
        return res;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited){
       visited[node] = true;
       for (int nei : adj.get(node)){
            if (!visited[nei]){
                dfs(nei, adj, visited);
            }
       }
    }
}
