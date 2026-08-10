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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(subRoot==null) return true;
        // 这段逻辑错误： 只要2个根节点相等就直接判断左右子树是否相同并return掉，但是如果有不匹配2棵树会得到false不会继续递归了
        // if(root.val == subRoot.val) return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        // return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        if(sameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean sameTree(TreeNode node1, TreeNode node2){
        if(node1==null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val == node2.val) return sameTree(node1.left, node2.left)&&sameTree(node1.right, node2.right);
        return false;
    }
}
