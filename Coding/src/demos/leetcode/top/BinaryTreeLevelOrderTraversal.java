/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
*/
package demos.leetcode.top;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root==null) return list;
        queue.offer(root);
        int size = 1;
        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tmp.add(node.val);
            if (node.left!=null) queue.offer(node.left);
            if (node.right!=null) queue.offer(node.right);
            if (--size == 0) {
                list.add(tmp);
                tmp = new ArrayList<>();
                size = queue.size();
            }
        }
        return list;
    }
}
