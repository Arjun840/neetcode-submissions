class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // Find where the cycle is and return the node that causes it
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            boolean[] visited = new boolean[n + 1];

            if (dfs(edge[0], adj, visited, -1)){
                return edge;
            }
        }
        return new int[0];
    }
    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited 
    , int parent){
        if (visited[node]){
            return true;
        }
        visited[node] = true;
        for (int nei : adj.get(node)){
            if (nei == parent){
                continue;
            }
            if (dfs(nei, adj, visited, node)){
                return true;
            }
        }
        return false;
        }
    }
