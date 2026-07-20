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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        helper(root, curr, ans);

        return ans;
    }

    void helper(TreeNode root, List<Integer> curr, List<String> ans){
        if(root == null) return;

        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder("");
            for(int i : curr) sb.append( Integer.toString(i) + "->" );
            sb.append( Integer.toString(root.val));
            ans.add(sb.toString());
        }

        curr.add(root.val);
        helper(root.left, curr, ans);
        helper(root.right, curr, ans);
        curr.remove(curr.size()-1);
    }
}