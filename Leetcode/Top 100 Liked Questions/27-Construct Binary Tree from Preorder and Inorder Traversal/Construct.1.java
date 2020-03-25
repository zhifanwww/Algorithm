/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode ret = new TreeNode();
        if (preorder.length == 0)
            return null;
        else {
            traverseBuild(ret, preorder, inorder);
        }
        ;
        return ret;

    }

    private void traverseBuild(TreeNode root, int[] preorder, int[] inorder) {
        int rootVal = preorder[0];
        int endIndex = getRootIndex(inorder, rootVal);
        root.val = rootVal;

        if (0 < endIndex) {
            root.left = new TreeNode();
            traverseBuild(root.left, Arrays.copyOfRange(preorder, 1, endIndex + 1),
                    Arrays.copyOfRange(inorder, 0, endIndex));
        }
        if (endIndex + 1 < preorder.length) {
            root.right = new TreeNode();
            traverseBuild(root.right, Arrays.copyOfRange(preorder, endIndex + 1, preorder.length),
                    Arrays.copyOfRange(inorder, endIndex + 1, inorder.length));
        } else
            return;

    }

    private int getRootIndex(int[] inorder, int rootVal) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }
}

/* First try: */