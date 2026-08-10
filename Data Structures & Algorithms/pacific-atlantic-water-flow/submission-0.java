class Solution {
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int j = 0; j < cols; j++){
            dfs(0,j,pacific, heights); // Top Edge
            dfs(rows-1, j, atlantic, heights); // Bottom Edge
        }

        for (int i = 0; i < rows; i++){
            dfs(i, 0, pacific, heights); // Left Edge
            dfs(i, cols-1, atlantic, heights);
        }
        List<List<Integer>> solution = new ArrayList<>();
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (pacific[i][j] && atlantic[i][j]){
                    solution.add(Arrays.asList(i,j));
                }
            }
        }
        return solution;
    }

    private void dfs(int i, int j, boolean[][] oceans, int[][] heights){
        oceans[i][j] = true;
        for (int[] dir : directions){
            int dirI = i + dir[0];
            int dirJ = j + dir[1];
            if (dirI >= 0 && dirI < heights.length && dirJ >= 0 && dirJ
            < heights[0].length && !oceans[dirI][dirJ] && heights[dirI][dirJ] >=
            heights[i][j]){
                dfs(dirI, dirJ, oceans, heights);
            }
        }
    }
}
