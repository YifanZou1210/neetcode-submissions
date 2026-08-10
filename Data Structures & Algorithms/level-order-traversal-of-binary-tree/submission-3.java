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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while(deque.isEmpty()==false){
            int len = deque.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i<len; i++){
                TreeNode node = deque.poll();
                tmp.add(node.val);
                if(node.left!=null) deque.offer(node.left);
                if(node.right!=null) deque.offer(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
