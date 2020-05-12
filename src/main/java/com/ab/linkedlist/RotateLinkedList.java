package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer.
 * 10->20->30->40->50->60 and k is 4, the list should be modified after clockwise to 30->40->50->60->10->20
 * 10->20->30->40->50->60 and k is 4, the list should be modified after couter clockwise to 50->60->10->20->30->40
 */
public class RotateLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        Node<Integer> head1 = linkedList1.getSampleLinkedList();

        System.out.println("Printing linked list:");
        LinkedList.printLinkedList(head1);

        int noOfRotation = 4; //also kth
        Node<Integer> newHead1 = rotateCounterClockwise(head1,noOfRotation);
        System.out.println(String.format("Printing linked list after %s counter clockwise rotation : ", noOfRotation));
        LinkedList.printLinkedList(newHead1);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        Node<Integer> head2 = linkedList2.getSampleLinkedList();

        Node<Integer> newHead2 = rotateClockwise(head2,noOfRotation);
        System.out.println(String.format("Printing linked list after %s clockwise rotation : ", noOfRotation));
        LinkedList.printLinkedList(newHead2);
    }

    private static Node<Integer> rotateClockwise(Node<Integer> head, int rotation) {
        return rotateCounterClockwise(head,LinkedList.getNodeCounts(head) - rotation);
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
