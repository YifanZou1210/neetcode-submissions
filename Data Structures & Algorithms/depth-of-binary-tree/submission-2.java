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
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.push(root);
        int depth = 0;
        while(dq.isEmpty()==false){
            int len = dq.size();
            for( int i = 0; i<len;i++){
                TreeNode node = dq.removeFirst();
                if(node.left!=null) dq.addLast(node.left);
                if(node.right!=null) dq.addLast(node.right);
            }
            depth+=1;
        }
        return depth;
    }
}
