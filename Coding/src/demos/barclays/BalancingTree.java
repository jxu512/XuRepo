package demos.barclays;

import java.util.ArrayList;
import java.util.List;

public class BalancingTree {

	public void balancing(Node root) {
		
		// Traverse tree to get sorted list
		List<Integer> list =new ArrayList<>(); 
		getList(root, list);
		// Construc balanced tree
		Node balanced = conctructTree(list);
	}

	private Node conctructTree(List<Integer> list) {
		// TODO Auto-generated method stub
		return build(0, list.size()-1, list);
		
	}

	private Node build(int i, int j, List<Integer> list) {
		// TODO Auto-generated method stub

		if(i==j) return new Node(list.get(i));
		int mid=i+(j-i)/2;
		Node n = new Node(list.get(mid));
		n.left=build(i,mid-1,list);
		n.right=build(mid+1,j, list);
		
		return n;
	}

	private void getList(Node root, List<Integer> list) {
		// TODO Auto-generated method stub

		if(root.left!=null) getList(root.left, list);
		list.add(root.val);
		if(root.right!=null) getList(root.right, list);
	}
	
	// Main
	public static void main(String[] args) {
		
		BalancingTree bal = new BalancingTree();
		Node node = bal.initTree();
		List<Integer> list =new ArrayList<Integer>();
		bal.getList(node, list);
		Node balanced = bal.conctructTree(list);
		List<Integer> list1 =new ArrayList<Integer>();
		bal.getList(balanced, list1);
		System.out.println(list1);
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
