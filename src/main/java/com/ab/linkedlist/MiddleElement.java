package com.ab.linkedlist;

/**
 * Given a singly linked list of N nodes.Print middle of the linked list.
 * Odd: 1->2->3->4->5 then output should be 3.
 * Even: 1->2->3->4->5->6 then output should be 4.//print second middle element.
 *
 * @author Arpit Bhardwaj
 */
public class MiddleElement {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Node<Integer> head = linkedList.getSampleLinkedList();

        System.out.println("Printing linked list:");
        LinkedList.printLinkedList(head);

        Node<Integer> middleNode = getMiddleElement(head);
        System.out.println("Middle node : " + middleNode.data);
    }

    private static Node<Integer> getMiddleElement(Node<Integer> head) {
        Node slowPointer = head;
        Node fastPointer = head;
        if (head != null){
            while (slowPointer != null && fastPointer != null){
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
        }
        return slowPointer;
    }
}
