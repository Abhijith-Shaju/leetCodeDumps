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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if(n == 0)return null;

        TreeNode root = new TreeNode(preorder[0]);
        if(n == 1)return root;

        int left = preorder[1];
        int index = 0;

        while(postorder[index] != left){
            index++;
        }

        root.left = constructFromPrePost( Arrays.copyOfRange(preorder, 1, index + 2), Arrays.copyOfRange(postorder, 0, index + 1) );
        root.right = constructFromPrePost( Arrays.copyOfRange(preorder, index + 2, n), Arrays.copyOfRange(postorder, index + 1, n-1) );

        return root;
    }
}