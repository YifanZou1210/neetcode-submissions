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
        if(preorder.length == 0 || inorder.length==0) return null;
        int rootvalue = preorder[0];
        List<Integer> inOrder = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        int rootidx = inOrder.indexOf(rootvalue);// get first index of rootvalue in inOrder;
        TreeNode root = new TreeNode(rootvalue);

        List<Integer> inleft = new ArrayList<>(inOrder.subList(0, rootidx));
        List<Integer> inright = new ArrayList<>(inOrder.subList(rootidx+1, inOrder.size()));
        int [] inLeft = inleft.stream().mapToInt(Integer::intValue).toArray();
        int [] inRight = inright.stream().mapToInt(Integer::intValue).toArray();

        int[] preleft = Arrays.copyOfRange(preorder, 1, 1+inleft.size());
        int[] preright = Arrays.copyOfRange(preorder, 1+inleft.size(), preorder.length);

        root.left = buildTree(preleft, inLeft);
        root.right = buildTree(preright, inRight);
        return root;

    }
}
