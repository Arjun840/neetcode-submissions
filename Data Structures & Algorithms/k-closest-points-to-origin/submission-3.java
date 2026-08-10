class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // The k closest points to origin are the k
        // points with the smallest euclidean distance to origin
        // We can calculate all the distances add them to a heap
        // We will store the the distance, x coord, y coord, in an array
         PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing
         (a -> a[0]));
         for (int[] point : points){
            int distance = (point[0])*(point[0])  + (point[1])*(point[1]);
            minHeap.offer(new int[] {distance, point[0], point[1]});
         }
         int[][] res = new int[k][2];
         for (int i = 0; i < k; i++){
            int[] curr = minHeap.poll();
            res[i] = new int[]{curr[1],curr[2]};
         }
    return res;
    }
}
