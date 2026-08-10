class Solution {
    private static final int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0){
                    q.add(new int[] {i, j});
                }
            }
        }
        if (q.size() == 0){
            return;
        }
        while (!q.isEmpty()){
            int[] cord = q.poll();
            int row = cord[0];
            int col = cord[1];
            for (int[] dir : directions){
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= grid.length || c >= grid[0].length || r < 0 
                | c < 0 || grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[] {r, c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
