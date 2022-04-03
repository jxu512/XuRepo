/*
https://leetcode.com/problems/balanced-binary-tree/
*/
package demos.leetcode;

public class BalancedBinaryTreeWithException {
    public boolean isBalanced(TreeNode1 root) {
        try{
        	dfsHeight(root);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    int dfsHeight(TreeNode1 root) throws Exception{
        if(root==null){
            return 0;
        }
        int left=dfsHeight(root.left);
        int right=dfsHeight(root.right);
        // Use exception to unwind recursion
        if(Math.abs(left-right)>1){
            throw new Exception("Unbalanced");
        }
        return Math.max(left,right) + 1;
    }
}

class TreeNode1 {
	 int val;
	 TreeNode1 left;
	 TreeNode1 right;
	 TreeNode1() {}
	 TreeNode1(int val) { this.val = val; }
	 TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
	     this.val = val;
	     this.left = left;
	     this.right = right;
	 }
}
