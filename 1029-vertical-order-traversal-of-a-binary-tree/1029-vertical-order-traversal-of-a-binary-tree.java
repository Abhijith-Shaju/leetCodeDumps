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
    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>> > map = new TreeMap<>();

    public void helper(TreeNode root, int order, int level){
        if(root == null) return;

        map.putIfAbsent(order, new TreeMap<>() );

        map.get(order).putIfAbsent(level, new ArrayList<>() );

        map.get(order).get(level).add(root.val);


        helper(root.left, order-1, level + 1);
        helper(root.right, order+1, level + 1);

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        helper(root, 0, 0);

        for (TreeMap<Integer, ArrayList<Integer>> columnMap : map.values()) {
            List<Integer> vertical = new ArrayList<>();
            
            for (ArrayList<Integer> arr : columnMap.values()) {
                Collections.sort(arr);
                for(int i : arr){
                    vertical.add(i);
                }
            }
            ans.add(vertical);
        }
        return ans;
    }
}