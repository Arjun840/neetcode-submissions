/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    // DFS approach, we want to see the depth
    // We will check the max between our curr result and left + right length
    // then we add one and iterate again unitl end of tree
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left, res); // left height
        int right = dfs(root.right, res); // right height
        res[0] = Math.max(res[0], left + right); // biggest diameter
        return 1 + Math.max(left, right);  
    }


}
