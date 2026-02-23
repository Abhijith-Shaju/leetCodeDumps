/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        String str = String.valueOf(root.val) + " ";
        String ans = str + serialize(root.left) + serialize(root.right);

        System.out.println(ans);
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] str = data.split(" ");

        int[] arr = new int[str.length];
        int ind = 0;
        for(String s : str) arr[ind++] = Integer.parseInt(s);

        TreeNode ans = new TreeNode(arr[0]);
        TreeNode curr = ans;
        for(int i = 1; i < arr.length; i++){
            curr = bst(ans, arr[i]);
        }
        return ans;
    }

    TreeNode bst(TreeNode root, int data){
        if(root == null) return new TreeNode(data);
        if(data <= root.val){
            root.left = bst(root.left, data);
        }else{
            root.right = bst(root.right, data);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;