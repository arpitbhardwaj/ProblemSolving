package com.ab.linkedlist;

import com.ab.linkedlist.impl.Node;
import com.ab.linkedlist.impl.SinglyLinkedList;

/**
 * @author Arpit Bhardwaj
 *
 * Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer.
 * 10->20->30->40->50->60 and k is 4, the list should be modified after clockwise to 30->40->50->60->10->20
 * 10->20->30->40->50->60 and k is 4, the list should be modified after couter clockwise to 50->60->10->20->30->40
 */
public class RotateLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> cll1 = new SinglyLinkedList<>();
        cll1.addLast(1);
        cll1.addLast(2);
        cll1.addLast(3);
        cll1.addLast(4);
        cll1.addLast(5);
        cll1.addLast(6);
        System.out.println("Printing linked list:");
        SinglyLinkedList.printLinkedList(cll1.head);

        int noOfRotation = 4; //also kth
        Node<Integer> newHead1 = rotateCounterClockwise(cll1.head,noOfRotation);
        System.out.println(String.format("Printing linked list after %s counter clockwise rotation : ", noOfRotation));
        SinglyLinkedList.printLinkedList(newHead1);

        SinglyLinkedList<Integer> cll2 = new SinglyLinkedList<>();
        cll2.addLast(1);
        cll2.addLast(2);
        cll2.addLast(3);
        cll2.addLast(4);
        cll2.addLast(5);
        cll2.addLast(6);
        System.out.println("Printing linked list:");
        SinglyLinkedList.printLinkedList(cll2.head);

        Node<Integer> newHead2 = rotateClockwise(cll2.head,noOfRotation);
        System.out.println(String.format("Printing linked list after %s clockwise rotation : ", noOfRotation));
        SinglyLinkedList.printLinkedList(newHead2);
    }

    private static Node<Integer> rotateClockwise(Node<Integer> head, int rotation) {
        return rotateCounterClockwise(head, SinglyLinkedList.getSize(head) - rotation);
    }

    private static Node<Integer> rotateCounterClockwise(Node<Integer> head, int rotation) {
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
