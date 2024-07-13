/*
https://leetcode.com/problems/delete-node-in-a-linked-list/description/
*/
package demos.leetcode.top;

public class DeleteNodeInALinkedList {
    public void deleteNode(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
}
