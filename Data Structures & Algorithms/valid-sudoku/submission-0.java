class Solution {
    public boolean isValidSudoku(char[][] board) {
        // board is 9 3x3 grids, 
        // we'll use a map with the key being the row/3and col/3
        // this will signify the correct box to look at
        // then, the value will be a set of values for that square,
        // if a repeat value occurs, then its not valid
        // need to utilize a separate map for rows, cols and squares
        // in order to make sure all are unique
        // row an col map simply use the row or col number to check
        // Loop through grid once, 9 checks 
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> square = new HashMap<>();
        for (int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){
                if (board[r][c] == '.'){
                    continue;
                }
                String key = (r/3) + "," + (c/3);
                if (rows.computeIfAbsent(r, k -> new HashSet<>()).
                contains(board[r][c]) || cols.computeIfAbsent(c, k -> new HashSet<>()).
                contains(board[r][c]) || square.computeIfAbsent(key, k -> new HashSet<>()).
                contains(board[r][c])){
                    return false;
                }
              rows.get(r).add(board[r][c]);
              cols.get(c).add(board[r][c]);
              square.get(key).add(board[r][c]);
            }
        }
        return true;
    }
}
