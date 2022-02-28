package demos.coding;

import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class IntegerListsSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        BigInteger num1=null;
        BigInteger num2 = null;
        StringBuilder sb = new StringBuilder();
        
        // Convert to numbers
        ListNode current = l1;
        while(current!=null) {
            sb.append(current.val);
            current=current.next;
        }
        num1 = new BigInteger(sb.toString());
        sb = new StringBuilder();
        current = l2;
        while(current!=null) {
            sb.append(current.val);
            current=current.next;
        }
        num2 = new BigInteger(sb.toString());
        
        BigInteger num3 = num1.add(num2);
        String s = num3.toString();
        // Convert cahr in string to int value
        ListNode result = new ListNode(s.charAt(0)-'0');
        current = result;
        for(int i=1;i<s.length();i++) {
            current.next=new ListNode(s.charAt(i)-'0');
            current=current.next;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	
    	IntegerListsSum sum = new IntegerListsSum();
    	sum.exec();
    }

	private void exec() {

		ListNode l1 = new ListNode(1);
		l1.next=new ListNode(2);
		ListNode l2 = new ListNode(1);
		l2.next=new ListNode(2);
		l2.next.next=new ListNode(0);
		
		ListNode l3 = addTwoNumbers(l1, l2);
	}
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
