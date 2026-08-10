class Solution {
    private static final int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++){
            if (board[i][0] == 'O'){
                capture(board, i, 0);
            }
            if (board[i][cols-1] == 'O'){
                capture(board, i, cols-1);
            }
        }
        for (int j = 0; j < cols; j++){
            if (board[0][j] == 'O'){
                capture(board, 0, j);
            }
            if (board[rows-1][j] == 'O'){
                capture(board, rows-1, j);
            }
        }
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (board[r][c] == 'O'){
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T'){
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board, int r, int c){
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length ||
        board[r][c] != 'O'){
            return;
        }
        board[r][c] = 'T';
        for (int[] dir : directions){
            capture(board, r + dir[0], c + dir[1]);
        }
    }
}
