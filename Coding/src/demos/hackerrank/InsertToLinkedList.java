package demos.hackerrank;

import java.io.*;
import java.util.*;

public class InsertToLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
        System.out.println();
    }

        /*
         * Complete the 'insertNodeAtPosition' function below.
         *
         * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
         * The function accepts following parameters:
         *  1. INTEGER_SINGLY_LINKED_LIST llist
         *  2. INTEGER data
         *  3. INTEGER position
         */

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */

        public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
            // Write your code here
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            SinglyLinkedListNode current = llist;
            SinglyLinkedListNode prevNode = null;
            int i = -1;
            while (current != null) {
                i++;
                if (position == i) {
                    newNode.next = current;
                    if (prevNode != null) prevNode.next = newNode;
                    break;
                }

                prevNode = current;
                current = current.next;
            }
            return llist;
        }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();
        SinglyLinkedListNode node;
        node = new SinglyLinkedListNode(16);
        llist.head = node;
        node.next = new SinglyLinkedListNode(13);
        node = node.next;
        node.next = new SinglyLinkedListNode(7);
        node = node.next;
        node.next = new SinglyLinkedListNode(-5);
        node = node.next;
        node.next = new SinglyLinkedListNode(21);

        printSinglyLinkedList(llist.head, ",");
        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, 1, 2);
        printSinglyLinkedList(llist.head, ",");
    }
}
