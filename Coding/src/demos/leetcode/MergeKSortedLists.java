/*
https://leetcode.com/problems/merge-k-sorted-lists/description/
*/

package demos.leetcode;

public class MergeKSortedLists {

    // Merge all lists at once
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode();
        ListNode current = root;
        ListNode next;
        while ((next=getNext(lists)) !=null) {
            current.next = next;
            current = current.next;
        }
        return root.next;
    }

    private ListNode getNext(ListNode[] lists) {
        ListNode min = null;
        int minIdx = -1;
        for (int i=0;i<lists.length;i++) {
            if (lists[i] != null) {
                if (min==null) {
                    min = lists[i];
                    minIdx = i;
                }
                else if (min.val > lists[i].val){
                    min = lists[i];
                    minIdx=i;
                }
            }
        }
        if (minIdx!=-1) lists[minIdx] = lists[minIdx].next;
        return min;
    }

    // Merge two at a time, this improves performance where a portion of one list is copied over without reordering
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    private ListNode[] init() {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        return lists;
    }
    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode node = mergeKSortedLists.mergeKLists1(mergeKSortedLists.init());
        System.out.println(node);
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
