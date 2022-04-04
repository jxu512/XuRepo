/*
https://leetcode.com/problems/binary-tree-right-side-view/
DFS
*/
package demos.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeRightSideViewDFS {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;

        dfs(root, 1, res);
        return res;
    }
    
    private void dfs(TreeNode node, int depth, List<Integer> res) {
        if(node==null) return;
        if(depth>res.size()) res.add(node.val);
        dfs(node.right, depth+1,res);
        dfs(node.left, depth+1,res);
    }
}