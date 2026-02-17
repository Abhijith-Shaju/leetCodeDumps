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
    TreeNode helper(int[] preorder, int pStart, int pEnd, int[]inorder, int iStart, int iEnd){
        if(iStart > iEnd || pStart >= preorder.length )return null;

        int i = iStart;
        while(inorder[i] != preorder[pStart]){
            i++;
        }
        int count = i - iStart;
        TreeNode root = new TreeNode(preorder[pStart]);
        
        root.left = helper(preorder, pStart + 1, pStart + count, inorder, iStart, i-1);
        root.right = helper(preorder, pStart + count + 1, pEnd, inorder, i+1, iEnd);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
}