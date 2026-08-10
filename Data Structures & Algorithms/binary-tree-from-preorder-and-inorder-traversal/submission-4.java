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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        int rootv = preorder[0];
        // int[] to List<Integer> 
        List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        int rootidx = in.indexOf(rootv);

        int [] inleft = Arrays.copyOfRange(inorder, 0, rootidx);
        int [] inright = Arrays.copyOfRange(inorder, rootidx+1, inorder.length);

        int[] preleft = Arrays.copyOfRange(preorder, 1, 1+inleft.length);
        int[] preright = Arrays.copyOfRange(preorder, 1+inleft.length, preorder.length);

        TreeNode root = new TreeNode(rootv);
        root.left = buildTree(preleft, inleft);
        root.right = buildTree(preright, inright);

        return root;

    }
}
