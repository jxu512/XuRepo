package demos.companies.barclays;

public class BalancingTreeDSW {

	private int bstToVine(Node grand)
	{
	    int count = 0;
	  
	    // Right flatten the given BST.
	    Node tmp = grand.right;
	  
	    // Traverse until tmp becomes NULL
	    while (tmp!=null) {
	        // If left exist for node, right rotate it.
	        if (tmp.left!=null) {
	           Node oldTmp = tmp;
	            tmp = tmp.left;
	            oldTmp.left = tmp.right;
	            tmp.right = oldTmp;
	            grand.right = tmp;
	        }
	        // If left does not exists, add 1 to count and traverse further right
	        else {
	            count++;
	            grand = tmp;
	            tmp = tmp.right;
	        }
	    }
	  
	    return count;
	}
	private void compress(Node root, int m)
	{
	    Node tmp = root.right;
	  
	    // Traverse and left-rotate root m times to compress given vine form of BST.
	    for (int i = 0; i < m; i++) {
	        Node oldTmp = tmp;
	        tmp = tmp.right;
	        root.right = tmp;
	        oldTmp.right = tmp.left;
	        tmp.left = oldTmp;
	        root = tmp;
	        tmp = tmp.right;
	    }
	}
	public Node balanceBST(Node root)
	{
	    // create dummy node with value 0
	    Node grand = new Node(0);
	    grand.right = root;
	  
	    // Convert bst into right linked list and return count
	    int count = bstToVine(grand);
	  
	    // get the height of tree in which all levels
	    int h = (int)(Math.log(count+1)/Math.log(2));
	    // get number of nodes until second last level
	    int m = (int)(Math.pow(2, h) - 1);
	    
	    // Left rotate for excess nodes at last level
	    compress(grand, count - m);
	    // Left rotation till m becomes 0
	    for (m = m / 2; m > 0; m /= 2) {
	        compress(grand, m);
	    }
	  
	    // return the balanced tree
	    return grand.right;
	}
	// Main
	public static void main(String[] args) {
		
		BalancingTreeDSW bal = new BalancingTreeDSW();
		Node node = bal.initTree();
		Node balanced = bal.balanceBST(node);
		System.out.println(balanced);
	}
	
	private Node initTree() {
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		Node n6=new Node(6);
		Node n7=new Node(7);

		n6.left=n4;
		n6.right=n7;
		
		n4.left=n2;
		n4.right=n5;
		
		n2.left=n1;
		n2.right=n3;
		
		return n6;
	}
}
