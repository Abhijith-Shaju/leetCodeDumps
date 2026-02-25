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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode top = q.poll();

                if(top.left != null){
                    parent.put(top.left.val, top);
                    q.offer(top.left);
                }

                if(top.right != null){
                    parent.put(top.right.val, top);
                    q.offer(top.right);
                }
            }
        }

        Map<Integer, Integer> visited = new HashMap<>();
        q.offer(target);

        while( k > 0 && !q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode top = q.poll();

                visited.put(top.val, 1);
                if(top.left != null && !visited.containsKey(top.left.val)){
                    q.offer(top.left);
                }

                if(top.right != null && !visited.containsKey(top.right.val)){
                    q.offer(top.right);
                }

                if(parent.containsKey(top.val) && !visited.containsKey(parent.get(top.val).val)){
                    q.offer(parent.get(top.val));
                }
            }
            k--;
        }

        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }

        return ans;
    }
}