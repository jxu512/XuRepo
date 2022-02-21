package demos.coding;

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
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head==null || head.next==null) return head;
        
        ListNode prev, current, next;
        
        current = head;
        prev = null;
        while(true) {
            next = current.next;
            current.next = prev;
            if ( next==null) break;
            prev = current;
            current = next;
        }
        
        return current;
    }
}