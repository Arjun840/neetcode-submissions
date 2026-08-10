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
    public List<Integer> rightSideView(TreeNode root) {
        // we will do a bfs, and track the final node per level
        // this is the one thats visble from the right side so 
        // we add that to the result
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int finalVal = 0;
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if (curr != null){
                    finalVal = curr.val;
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
            if (finalVal != 0){
                res.add(finalVal);
            }
        }
        return res;
    }
}
