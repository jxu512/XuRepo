/*
https://leetcode.com/problems/even-odd-tree/description/
*/
package demos.leetcode.jp;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int levelCount = 1;
        int lastVal = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (level % 2 == 0) {
                if (node.val % 2 == 0 || (lastVal != 0 && node.val <= lastVal)) return false;
            } else {
                if (node.val % 2 == 1 || (lastVal != 0 && node.val >= lastVal)) return false;
            }
            lastVal = node.val;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            levelCount--;
            if (levelCount == 0) {
                lastVal = 0;
                level++;
                levelCount = queue.size();
            }
        }

        return true;
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

