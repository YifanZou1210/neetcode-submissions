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
    private int Depth = 1; 
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Depth = Math.max(Depth, getDepth(root));
        return Depth;
    }
    private int getDepth(TreeNode node){
        if(node == null) return 0;
        int left = getDepth(node.left), right = getDepth(node.right);
        return 1+Math.max(left, right);
    }
}
