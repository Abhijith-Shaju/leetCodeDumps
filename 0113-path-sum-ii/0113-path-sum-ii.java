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

    void helper(TreeNode root, int curr, int tar, List<List<Integer>> ans, List<Integer> path){
        if(root == null) return ;
        path.add(root.val);
        curr += root.val;

        if(root.left == null && root.right == null) {
            if(curr == tar){
                ans.add(new ArrayList<>(path) );
            }
        }else{
            helper( root.left, curr, tar, ans, path);
            helper( root.right, curr, tar, ans, path);
        }
        path.remove(path.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        List<Integer> curr = new ArrayList<>();
        helper( root, 0, targetSum, ans, curr);

        return ans;
    }
}