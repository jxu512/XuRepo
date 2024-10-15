/*
https://leetcode.com/problems/palindrome-linked-list/description/
*/
package demos.leetcode.top;

public class PalinDromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        ListNode[] heads = reverseHalf(head);
        while (heads[0] != null && heads[1] != null) {
            if (heads[0].val != heads[1].val) return false;
            heads[0] = heads[0].next;
            heads[1] = heads[1].next;
        }
        return true;
    }

    private ListNode[] reverseHalf(ListNode head) {
        int count = getCount(head);
        ListNode prev = null;
        int n = 0;
        while (n < count/2) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
            n++;
        }
        if (count % 2 == 1) head = head.next;
        return new ListNode[] { head, prev};
    }
    private int getCount(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /* Alternative: maintain two pointers, p1 = head, p2=head.next
    p1 advances by 1 while p2 advances by 2. Pust p1.val to stack until p2 is null.
    compare stack and p1.
     */
}
