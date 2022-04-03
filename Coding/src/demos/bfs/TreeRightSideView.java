/*
https://leetcode.com/problems/binary-tree-right-side-view/
*/
package demos.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depthSize = queue.size();
        boolean newDepth=true;
        while(!queue.isEmpty()) {
            TreeNode cur=queue.poll();
            if(newDepth) {
                res.add(cur.val);
                newDepth=false;
            }
            if(cur.right!=null) queue.offer(cur.right);
            if(cur.left!=null) queue.offer(cur.left);
            if(--depthSize==0) {
                newDepth=true;
                depthSize=queue.size();
            }
        }
        return res;
    }
}
