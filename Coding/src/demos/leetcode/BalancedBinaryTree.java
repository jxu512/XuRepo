/*
https://leetcode.com/problems/balanced-binary-tree/

Determine if a brinary tree is balanced.
*/
package demos.leetcode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return balancedHeight(root) != -1;
    }
    
    int balancedHeight(TreeNode node) {
        if(node==null) return 0;

        int left=balancedHeight(node.left);
        if(left==-1) return -1;

        int right=balancedHeight(node.right);
        if(right==-1) return -1;
        
        // Use special value -1 to unwind recursion
        if(Math.abs(left-right)>1) return -1;

        return Math.max(left,right) + 1;
    }
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode() {}
	 TreeNode(int val) { this.val = val; }
	 TreeNode(int val, TreeNode left, TreeNode right) {
	     this.val = val;
	     this.left = left;
	     this.right = right;
	 }
}
