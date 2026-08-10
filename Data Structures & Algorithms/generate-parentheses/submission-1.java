class Solution {
    public List<String> generateParenthesis(int n) {
        // U can never have more closing parenthese than open
        // We'll use recursive backtracking and go until openN == n and
        // closedN == openN means that the pair is closed
        // We'll have two backtrack pathways, when openN < n meaning
        // more parentheses can be added and when closedN < openN meaning
        // the pair still needs to be closed
        // In backtracking, we'll delete the last char to undo that change
        // and allow the option to explore other pahts in the tree
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(n, 0, 0, res, stack);
        return res;
    }

    private void backtrack(int n, int openN, int closedN, List<String> res,
    StringBuilder stack){
        if (openN == n && closedN == openN){
            res.add(stack.toString());
            return;
        }
        if (openN < n){
            stack.append('(');
            backtrack(n, openN + 1, closedN, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (closedN < openN){
            stack.append(')');
            backtrack(n, openN, closedN + 1, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
