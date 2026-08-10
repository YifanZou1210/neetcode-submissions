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
    public boolean isSubtree(TreeNode root, TreeNode sub) {
        if(root == null && sub == null) return true;
        if(root == null) return false;
        if(sub == null) return true;
        if(root.val == sub.val){
            if(sameTree(root, sub)) return true;
        }
    return isSubtree(root.left, sub) || isSubtree(root.right, sub);

    }
    private boolean sameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val!=q.val) return false;
        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }
}
