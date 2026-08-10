class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>(); // Make adjacency list for each node, the connecting node and distacne
        for (int[] time : times){ // for each time
            edges.putIfAbsent(time[0], new ArrayList<>());
            edges.get(time[0]).add(new int[]{time[1], time[2]}); // add the source, destination and distance
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])); // comparing by distance
            minHeap.offer(new int[]{0, k}); // distance to start node is 0

            Set<Integer> visited = new HashSet<>();
            int t = 0;
            while (!minHeap.isEmpty()){
                int[] curr = minHeap.poll();
                int w1 = curr[0], n1 = curr[1];
                if (visited.contains(n1)){
                    continue;
                }
                visited.add(n1);
                t = w1;
                if (edges.containsKey(n1)){
                    for (int[] next : edges.get(n1)){
                        int n2 = next[0], w2 = next[1];
                        if (!visited.contains(n2)){
                            minHeap.offer(new int[]{w1 + w2, n2});
                        }
                    }
                }
            }
            return visited.size() == n ? t : -1;
    }
}
