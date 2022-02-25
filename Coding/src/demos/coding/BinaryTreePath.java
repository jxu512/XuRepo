import java.util.ArrayList;
import java.util.List;

/*
 * List all paths for binary tree. Using backtracking.
 * 
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

    public void getPath(TreeNode node){
        if(node == null) return;

        path.add(String.valueOf(node.val));
        if(node.left == null && node.right == null){
        	result.add(String.join("->",path));
        }
        getPath(node.left);
        getPath(node.right);

        path.remove(path.size()-1);
    }
}