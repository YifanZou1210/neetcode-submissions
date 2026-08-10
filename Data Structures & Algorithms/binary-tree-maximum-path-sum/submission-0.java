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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    //返回从当前节点向上能贡献的最大路径和，注意是单边，即当前节点的左右子树
    private int dfs(TreeNode node){
        if(node==null) return 0;
        //dfs(node.left)计算从当前节点的左孩子出发，到它的子孙中单边最长路径之和
        // 加Math.max()是为了如果左子树的路径贡献为0， 就干脆舍去左子树
        int leftgain = Math.max(dfs(node.left), 0);
        int rightgain = Math.max(dfs(node.right),0);

        int curMaxPath = node.val+leftgain+rightgain;//局部贡献之和

        maxSum = Math.max(maxSum, curMaxPath);//全局局部贡献之和
        return node.val+Math.max(leftgain, rightgain);
    }
}
