/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // TreeNode ans = new TreeNode(-1);
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root);

        // while( !queue.isEmpty() ) {
        //     TreeNode temp = queue.poll();

        //     if( helper(temp, p.val) && helper(temp, q.val) ) ans = temp;
        
        //     if(temp.left != null) queue.offer(temp.left);
        //     if(temp.right != null) queue.offer(temp.right);
        // }

        // return ans;

        if( root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if( left != null & right != null ) return root;

        return left != null ? left : right;
    }

    boolean helper(TreeNode root, int val){
        if(root == null) return false;
        if(root.val == val) return true;
        
        return ( helper(root.left, val) || helper(root.right, val) );
    }
}