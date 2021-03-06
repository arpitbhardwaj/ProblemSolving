package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * Hashing:
 * Approach using Mark Visited Nodes:
 * Floyd’s Cycle-Finding Algorithm:
 *
 */
public class DetectLoop<T> {
    public static void main(String[] args) {
        DetectLoop detectLoop = new DetectLoop();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Node<Integer> head = linkedList.getSampleLinkedList();

        System.out.println("Printing linked list:");
        LinkedList.printLinkedList(head);

        System.out.println("Adding Loop:");
        detectLoop.addLoop(head);

        //leads to indefinite printing due to presence of loop
        /*System.out.println("Printing Looped linked list:");
        LinkedList.printLinkedList(head);*/

        boolean loopPresent = detectLoop.detectLoop(head);
        System.out.println("Loop present in the linked list : " + loopPresent);
        if(loopPresent){
            System.out.println("Removing Loop:");
            detectLoop.detectAndRemoveLoop(head);
            System.out.println("Printing linked list:");
            LinkedList.printLinkedList(head);
        }
    }

    private void addLoop(Node<T> head) {
        //add loop
        Node<T> currentNode = head;
        Node<T> lastNode = head;
        //get the last node
        while (currentNode != null){
            lastNode = currentNode;
            currentNode = currentNode.next;
        }
        //attach the last node to second node
        lastNode.next = head.next;
        //or
        //head.next.next = head.next.next.next.next;
    }

    private boolean detectLoop(Node<T> head) {
        Node<T> slowPointer = head;
        Node<T> fastPointer = head;
        if (head != null){
            while (slowPointer != null && fastPointer != null){
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
                if(slowPointer == fastPointer){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectAndRemoveLoop(Node<T> head) {
        Node<T> slowPointer = head;
        Node<T> fastPointer = head;
        if (head != null){
            while (slowPointer != null && fastPointer != null){
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
                if(slowPointer == fastPointer){
                    removeLoop(slowPointer,head);
                    return true;
                }
            }
        }
        return false;
    }

    private void removeLoop(Node<T> loopNode, Node<T> head) {
        Node ptr1 = loopNode;
        Node ptr2 = loopNode;

        System.out.println("Looped node : " + loopNode.data);
        int k = 1;//counter for number of nodes

        // Count the number of nodes in loop
        while (ptr1.next != ptr2){
            ptr1 = ptr1.next;
            k++;
        }

        System.out.println("Number of nodes in loop : " + k);
        // Fix one pointer to head
        ptr1 = head;

        // And the other pointer to k nodes after head
        ptr2 = head;
        for (int i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }

        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        System.out.println("Loop Starting Node : " + ptr1.data);

        // Get pointer to the last node
        while (ptr2.next != ptr1){
            ptr2 = ptr2.next;
        }

        System.out.println("Loop Last Node : " + ptr2.data);

        ptr2.next = null;
    }
}
