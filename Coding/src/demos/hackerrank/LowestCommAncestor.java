/*
Sample:
8
8 4 9 1 2 3 6 5
1 2
*/

package demos.hackerrank;

import java.util.*;
import java.io.*;

class Node10 {
	Node10 left;
	Node10 right;
    int data;
    
    Node10(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LowestCommAncestor {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node10 lca(Node10 root, int v1, int v2) {
      	// Write your code here.

          List<Node10> p1=new ArrayList<>();
          List<Node10> p2=new ArrayList<>();
          p1=findPath(root, v1);
          p2=findPath(root,v2);
          int minLen=p1.size()<p2.size()?p1.size():p2.size();
          for(int i=1;i<minLen;i++) {
              if(p1.get(i)!=p2.get(i)) return p1.get(i-1);
          }
          return root;
    }
    private static List<Node10> findPath(Node10 r, int v){
        
        List<Node10> p=new ArrayList<>();
        Node10 cur = r;
        while(true){
            p.add(cur);
            if(cur.data==v) return p;
            else if(v<cur.data) cur=cur.left;
            else cur=cur.right;
        }
    }
	public static Node10 insert(Node10 root, int data) {
        if(root == null) {
            return new Node10(data);
        } else {
        	Node10 cur;
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
        Node10 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node10 ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}