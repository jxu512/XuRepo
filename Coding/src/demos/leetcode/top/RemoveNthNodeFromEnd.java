/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
*/
package demos.leetcode.top;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        int sz = nodes.size();
        if (sz == 1) return null;
        if (sz == n) return head.next;
        ListNode n1 = nodes.get(sz-1-n);
        n1.next = n1.next.next;
        return head;
    }
}
