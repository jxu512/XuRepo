package demos.tree;

public class TreeDepth {

    public int maxDepth(TreeNode node) {
        
        if(node==null) return 0;
        return Math.max(maxDepth(node.left),maxDepth(node.right))+1;
    }
}