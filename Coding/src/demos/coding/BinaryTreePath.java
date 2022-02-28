import java.util.ArrayList;
import java.util.List;

/*
 * List all paths for binary tree. Using backtracking.
 * Return list of path as string
 */
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
class BinaryTreePath {
    List<String> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {

        getPath(root);
        return result;
    }
    // Get all paths
    public void getPath(TreeNode node){
        // Exit condition
    	if(node == null) return;
    	// Add to path
        path.add(String.valueOf(node.val));
        if(node.left == null && node.right == null){
        	result.add(String.join("->",path));
        	return;
        }
        
        // Recursion
        getPath(node.left);
        getPath(node.right);
        //Remove this node and continue
        path.remove(path.size()-1);
    }
    // Traversal of all nodes inorder
    public void traverse(TreeNode node, List<Integer> result){

    	result.add(node.val);
        // Recursion
    	if(node.left!=null) traverse(node.left);
    	if(node.right!=null) traverse(node.right);

    }
}