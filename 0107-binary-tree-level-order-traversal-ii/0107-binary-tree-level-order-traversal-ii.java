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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while( !q.isEmpty() ){
            List<Integer> arr = new ArrayList<>();
            
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = new TreeNode();
                temp = q.peek();
            
                arr.add(temp.val);
                if(temp.left != null)q.offer(temp.left);
                if(temp.right != null)q.offer(temp.right);
            
                q.poll();
            }

            ans.add(0, arr);
        } 

        return ans;

    }
}