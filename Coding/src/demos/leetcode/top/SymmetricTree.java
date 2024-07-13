/*
https://leetcode.com/problems/symmetric-tree/description/
*/
package demos.leetcode.top;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        else if (root.left == null || root.right == null) return false;

        return compareChildren(root.left, root.right);
    }
    private boolean compareChildren(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;

        if (left.val == right.val) return compareChildren(left.left, right.right) && compareChildren(left.right, right.left);
        else return false;
    }
}
