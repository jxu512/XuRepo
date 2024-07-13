/*
https://leetcode.com/problems/linked-list-cycle/description/
*/
package demos.leetcode.top;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    // Floyd's Cycle Finding Algorithm
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2!=null) p2 = p2.next;
            else break;
            if (p1 == p2) return true;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
