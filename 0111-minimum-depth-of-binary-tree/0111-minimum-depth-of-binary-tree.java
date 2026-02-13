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

    int helper(TreeNode root, int level){
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null){
            return level;
        }
        return Math.min(helper(root.left, level+1), helper(root.right, level+1));
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 1);       
    }
}