/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        traverseVaid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return valid;

    }

    private void traverseVaid(TreeNode root, long min, long max) {

        if (root.val <= min || root.val >= max)
            valid = false;
        if (root.left != null && valid == true) {
            traverseVaid(root.left, min, root.val);
        }
        if (root.right != null && valid == true) {
            traverseVaid(root.right, root.val, max);
        }
    }
}

/*
 * BST:
 * 
 * all left nodes < root node; all right nodes > root node
 * 
 * then, a left node: < root node
 * 
 * a right node : > root node but < root node of root node
 * 
 * Point: Use Long.MAX_VALUE in case of the edge int
 * 
 */