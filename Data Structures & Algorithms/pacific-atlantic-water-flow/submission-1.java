class Solution {
    private static final int[][] directions = {{1,0},{0,1}, {0,-1}, {-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];
        for (int r = 0; r < ROWS; r++){
            dfs(r, 0, pac, heights);
            dfs(r, COLS - 1, atl, heights);
        }
        for (int c = 0; c < COLS; c++){
            dfs(0, c, pac, heights);
            dfs(ROWS - 1, c, atl, heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLS; j++){
                if (pac[i][j] && atl[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        // set true for visited
        ocean[r][c] = true;
        for (int[] d : directions){
            int row = r + d[0], col = c + d[1];
            if (row >= 0 && row < heights.length && col >= 0 && 
            col < heights[0].length && !ocean[row][col] && 
            heights[row][col] >= heights[r][c]){
                dfs(row, col, ocean, heights);
            }
        }
    }
}
