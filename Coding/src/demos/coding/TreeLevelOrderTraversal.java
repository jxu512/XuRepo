package demos.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
class TreeLevelOrderTraversal {
        /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> values = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
       
        queue.add(root);
        int depthCount=queue.size();
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            values.add(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
            if(--depthCount==0) {
                depthCount = queue.size();
                result.add(values);
                values=new ArrayList<Integer>();
            }
        }
        return null;
    }
         */
}