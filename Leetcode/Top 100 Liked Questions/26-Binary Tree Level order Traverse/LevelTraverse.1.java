import java.util.ArrayList;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) {
            traverse(root, 0);
        }

        return ret;

    }

    private void traverse(TreeNode root, int level) {
        if (ret.size() <= level) {
            ret.add(new ArrayList<>(Arrays.asList(root.val)));
        } else {
            ret.get(level).add(root.val);
        }

        if (root.left != null) {
            traverse(root.left, level + 1);
        }
        if (root.right != null) {
            traverse(root.right, level + 1);
        }

    }
}