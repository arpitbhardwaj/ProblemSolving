package com.ab.linkedlist;

/**
 * Print Nth node from the end of the linked list.
 *
 * @author Arpit Bhardwaj
 */
public class NthNodeFromEnd {
    public static void main(String[] args) {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        Node<Integer> head = customLinkedList.getSampleLinkedList();

        System.out.println("Printing linked list:");
        CustomLinkedList.printLinkedList(head);

        int nth = 4;
        Node<Integer> nthNode = getNthNode(head, nth);
        System.out.println(String.format("%sth node from end : %s", nth, nthNode.data));
    }

    private static Node<Integer> getNthNode(Node<Integer> head, int nth) {
        Node refPointer = head;
        Node mainPoint = head;

        int count = 0;
        while (count < nth){
            if(refPointer == null){
                throw new IllegalStateException(nth + " is greater than the no of nodes in the list");
            }
            refPointer = refPointer.next;
            count++;
        }
        while (refPointer != null){
            refPointer = refPointer.next;
            mainPoint = mainPoint.next;
        }
        return mainPoint;
    }
}
