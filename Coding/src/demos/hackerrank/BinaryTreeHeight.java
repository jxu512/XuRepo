package demos.hackerrank;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTreeHeight {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
      	// Write your code here.
    
        Queue<Node> queue=new LinkedList<Node>();
        queue.offer(root);
        int depth=0;
        int levelCount=1;
        while(!queue.isEmpty()) {
            Node current=queue.poll();
            if(current.left!=null) queue.offer(current.left);
            if(current.right!=null) queue.offer(current.right);
            if(--levelCount==0) {
                levelCount=queue.size();
                if(levelCount!=0) depth++;
            }
            
        }
        return depth;
    }

	public static Node insert(Node root, int data) {
	       if(root == null) {
	            return new Node(data);
	        } else {
	            Node cur;
	            if(data <= root.data) {
	                cur = insert(root.left, data);
	                root.left = cur;
	            } else {
	                cur = insert(root.right, data);
	                root.right = cur;
	            }
	            return root;
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        int t = scan.nextInt();
	        Node root = null;
	        while(t-- > 0) {
	            int data = scan.nextInt();
	            root = insert(root, data);
	        }
	        scan.close();
	        int height = height(root);
	        System.out.println(height);
	    }	
}
