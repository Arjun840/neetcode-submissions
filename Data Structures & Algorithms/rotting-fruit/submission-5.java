class Solution {
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if (grid[r][c] == 1){
                    fresh++;
                } else if (grid[r][c] == 2){
                    q.offer(new int[]{r, c});
                }
            }
        }
        // We have the # of fresh oranges and the coords of the rotten in queue
        while (fresh > 0 && !q.isEmpty()){
            int length = q.size(); // iterate through q
            for (int i = 0; i < length; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for (int[] dir : directions){
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if (row >= 0 && row < grid.length && col >= 0 && col <
                    grid[0].length && grid[row][col] == 1){
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if (fresh != 0){
            return -1;
        } else{
            return time;
        }
    }
}
