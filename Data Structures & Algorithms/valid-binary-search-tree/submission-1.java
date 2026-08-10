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
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        for(int i= 1;i<res.size();i++){
            if(res.get(i-1)>=res.get(i)){
                return false;
            }
        }
        return true;
    }
    private void dfs(TreeNode node){
        if(node==null) return ;
        if(node.left!=null) dfs(node.left);
        res.add(node.val);
        if(node.right!=null) dfs(node.right);
    }
}
