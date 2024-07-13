package demos.leetcode.top;

public class ReverseSinglyLinkedList {
        public ListNode reverseList(ListNode head) {
            ListNode current = head;
            ListNode prev = null;
            while (current != null) {
                ListNode tmp = current.next;
                current.next = prev;
                prev = current;
                current = tmp;
            }
            return prev;
        }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
