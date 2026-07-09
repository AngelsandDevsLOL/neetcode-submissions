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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "x";
        String left = serialize(root.left);
        String right = serialize(root.right);
        StringBuilder sb = new StringBuilder();
        sb.append(left.length() + " " + root.val + " ");
        sb.append(left + " " + right);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        if (data.equals("x")) return null;
        int firstSpace = data.indexOf(" ");
        int secondSpace = data.indexOf(" ", firstSpace + 1);
        int length = Integer.parseInt(data.substring(0, firstSpace));
        int root = Integer.parseInt(data.substring(firstSpace + 1, secondSpace));
        String left = data.substring(secondSpace + 1, secondSpace + 1 + length);
        String right = data.substring(secondSpace + 2 + length);
        TreeNode l = deserialize(left);
        TreeNode r = deserialize(right);
        TreeNode ret = new TreeNode(root, l, r);
        return ret;
    }
}