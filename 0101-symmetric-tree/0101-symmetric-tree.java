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
    boolean equals(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return (left.val == right.val) && equals(left.left, right.right) && equals(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) 
        // || (root.left == null && root.right == null) ) 
        return true;

        // if(root.left != null && root.right != null){
            return equals(root.left, root.right);
        // }
        // return false;
    }
}