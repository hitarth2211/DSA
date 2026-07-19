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
    int res;
    private int dfs(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        if((root.val >= leftMax) && (root.val >= rightMax)) res++;
        return Math.max(root.val, Math.max(leftMax, rightMax));
    }
    public int countDominantNodes(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }
}