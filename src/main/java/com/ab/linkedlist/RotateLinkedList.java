package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer.
 * if the given linked list is 10->20->30->40->50->60 and k is 4, the list should be modified to 50->60->10->20->30->40
 *
 */
public class RotateLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Node<Integer> head = linkedList.getSampleLinkedList();

        System.out.println("Printing linked list:");
        LinkedList.printLinkedList(head);

        int noOfRotation = 4; //also kth
        Node<Integer> newHead = rotateLinkedList(head,noOfRotation);
        System.out.println(String.format("Printing linked list after %s rotation : ", noOfRotation));
        LinkedList.printLinkedList(newHead);
    }

    private static Node<Integer> rotateLinkedList(Node<Integer> head, int rotation) {
        if(rotation == 0){
            return head;
        }
        Node current = head;
        int count = 1;
        while (count < rotation && current != null){
            current = current.next;
            count++;
        }
        if(current == null){
            return head;
        }

        Node kthNode = current;
        //traverse to last
        while (current.next != null){
            current = current.next;
        }

        // Change next of last node to previous head
        current.next = head;
        // Change head to (k+1)th node
        head = kthNode.next;
        // change next of kth node to null
        kthNode.next = null;

        return head;
    }
}
