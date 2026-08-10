class Solution {
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1},
    {0,-1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >=
        grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        for (int[] dir : directions){
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
