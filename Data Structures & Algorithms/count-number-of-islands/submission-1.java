class Solution {
    // Implement using a DFS using recursion
    // Check if an element in grid is a 1 or 0
    // If its a 0 skip
    // If its a 1, perform DFS from there
    // DFS will go in all 4 directions, up, down, left, and right
    // Finally turn that 1 into a 0 to make sure you don't check it again
    // Increment islands as you find them
    
    private static final int[][] directions = {{1,0}, {-1,0},{0,1}, {0,-1}};
    
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int islands = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0 ||  i >= grid.length ||
        j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0'; //Ensures we don't repeat islands
        for (int[] dir : directions){
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
