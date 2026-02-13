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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Double> arr = new ArrayList<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            double ans = 0.0;
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                ans += curr.val;
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }

            ans /= size;
            arr.add(ans);
        }   
        return arr;
    }
}