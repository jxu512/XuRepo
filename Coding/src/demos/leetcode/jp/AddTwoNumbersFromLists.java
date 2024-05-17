/*
https://leetcode.com/problems/add-two-numbers/description/
*/
package demos.leetcode.jp;

public class AddTwoNumbersFromLists {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carryOver = 0;
        ListNode p1 = l1, p2 = l2;
        ListNode r = new ListNode(-1);
        ListNode p3 = r;
        while (p1 != null || p2 != null) {
            int n1 = p1!=null ? p1.val : 0;
            int n2 = p2!=null ? p2.val : 0;
            int n = n1 + n2 + carryOver;
            if ( n>=10 ) {
                carryOver = 1;
                n %= 10;
            } else {
                carryOver = 0;
            }
            p3.next = new ListNode(n);
            p3 = p3.next;
            if (p1!=null) p1 = p1.next;
            if (p2!=null) p2 = p2.next;
        }
        if (carryOver==1) p3.next = new ListNode(1);
        return r.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}