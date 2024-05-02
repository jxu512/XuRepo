package demos.hackerrank;

import java.io.IOException;

public class MergeTwoSortedLists {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }

        static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

            SinglyLinkedListNode result, node;
            result = new SinglyLinkedListNode(0);
            node = result;
            while (head1 != null && head2 != null) {
                if (head1 != null && head2 != null) {
                    if (head1.data < head2.data) {
                        node.next = head1;
                        head1 = head1.next;
                    } else {
                        node.next = head2;
                        head2 = head2.next;
                    }
                    node = node.next;
                }

                if (head1 == null) node.next = head2;
                else if (head2 == null) node.next = head1;
            }
            return result.next;
        }

        static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
            while (node != null) {
                System.out.print(String.valueOf(node.data));

                node = node.next;

                if (node != null) {
                    System.out.print(sep);
                }
            }
            System.out.println();
        }

        public static void main(String[] args) throws IOException {
            SinglyLinkedListNode list1, list2, current;
            list1 = new SinglyLinkedListNode(2);
            current = list1;
            current.next = new SinglyLinkedListNode(3);
            current = current.next;
            current.next = new SinglyLinkedListNode(7);
            current = current.next;
            current.next = new SinglyLinkedListNode(8);
            current = current.next;
            current.next = new SinglyLinkedListNode(21);

            list2 = new SinglyLinkedListNode(1);
            current = list2;
            current.next = new SinglyLinkedListNode(7);
            current = current.next;
            current.next = new SinglyLinkedListNode(9);

            printSinglyLinkedList(list1, ",");
            printSinglyLinkedList(list2, ",");

            printSinglyLinkedList(mergeLists(list1, list2), ",");

        }
    }
}
