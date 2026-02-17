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
    TreeNode helper(int[] postorder, int pStart, int pEnd, int[]inorder, int iStart, int iEnd){
        if(iStart > iEnd || pStart < 0 )return null;

        int i = iStart;
        while(i <= iEnd && inorder[i] != postorder[pStart]){
            i++;
        }
        int count = i - iStart;
        TreeNode root = new TreeNode(postorder[pStart]);
        
        root.left = helper(postorder, pEnd + count - 1, pEnd, inorder, iStart, i-1);
        root.right = helper(postorder, pStart- 1, pEnd + count, inorder, i+1, iEnd);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder, postorder.length - 1, 0, inorder, 0, inorder.length - 1);

    }
}