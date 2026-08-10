class Solution {
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        // We can do a multisource bfs, starting it from each rotten orange
        // We loop through and check how many non-rotten oranges there are
        // We also get the coordinates of all rotten oranges
        // After this we can put the rotten ones in a queue
        // We go level by level, checking if they touch any other oranges
        // If they touch a non rotten orange we decrement that orange 
        // If there are non-rotten oragnes at the end we return -1;
        int time = 0;
        int fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0){
                    continue;
                } else if (grid[i][j] == 1){
                    fresh++;
                } else{
                    int[] coord = new int[] {i, j};
                    q.offer(coord);
                }
            }
        }
        while (!q.isEmpty() && fresh > 0){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] coordinate = q.poll();
                int r = coordinate[0];
                int c = coordinate[1];
                for (int[] dir : directions){
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if (row >= 0 && col >= 0 && row < grid.length &&
                    col < grid[0].length && grid[row][col] == 1){
                        q.offer(new int[] {row, col});
                        grid[row][col] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
