/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
    List<Integer> ret = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return ret;
        } else {
            traverse(root);
        }
        return ret;

    }

    private void traverse(TreeNode root) {
        if (root.left != null)
            traverse(root.left);
        ret.add(root.val);
        if (root.right != null)
            traverse(root.right);
    }
}