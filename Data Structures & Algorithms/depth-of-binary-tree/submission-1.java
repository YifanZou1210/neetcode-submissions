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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Deque<Pair<TreeNode, Integer>> stk = new ArrayDeque<>();
        stk.push(new Pair<>(root, 1));
        int max = 0;
        while(stk.isEmpty()==false){
            Pair<TreeNode, Integer> pair = stk.pop();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            max = Math.max(max, depth);
            if(node.left!=null) stk.push(new Pair<>(node.left, depth+1));
            if(node.right!=null) stk.push(new Pair<>(node.right, depth+1));
        }
        return max;
    }
}
