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
        if(root==null)return "null";
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(datas));
        return build(queue);
    }
    private TreeNode build(Queue<String> queue){
        String nodev = queue.poll();
        if(nodev.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(nodev));
        node.left = build(queue);
        node.right = build(queue);
        return node;
    }
}
