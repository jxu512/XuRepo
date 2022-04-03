/*
https://leetcode.com/problems/balanced-binary-tree/
*/
package demos.leetcode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
    int dfsHeight(TreeNode root){
        if(root==null) return 0;

        int left=dfsHeight(root.left);
        if(left==-1) return -1;

        int right=dfsHeight(root.right);
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
