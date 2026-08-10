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
    public List<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return res.get(k-1);
    }
    private void inorder(TreeNode node){
        if(node==null) return ;
        if(node.left!=null) inorder(node.left);
        res.add(node.val);
        if(node.right!=null) inorder(node.right);
    }
}
