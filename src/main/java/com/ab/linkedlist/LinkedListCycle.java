package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * Hashing:
 * Approach using Mark Visited Nodes:
 * Floyd’s Cycle-Finding Algorithm
 */
public class LinkedListCycle {
    private void addCycle(Node head) {
        Node currentNode = head;
        Node lastNode = head;
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

    private boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    private int cycleLength(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                int length = 0;
                Node temp = slow;
                do {
                    temp = temp.next;
                    length++;
                }while (temp!= slow);
                return length;
            }
        }
        return 0;
    }

    private boolean detectAndRemoveCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                removeCycle(slow,head);
                return true;
            }
        }
        return false;
    }

    private void removeCycle(Node loopNode, Node head) {
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

    public static void main(String[] args) {
        LinkedListCycle addRemoveLoop = new LinkedListCycle();

        CustomLinkedList<Integer> cll = new CustomLinkedList<>();
        cll.addLast(1);
        cll.addLast(2);
        cll.addLast(3);
        cll.addLast(4);
        cll.addLast(5);
        cll.addLast(6);
        System.out.println("Printing linked list:");
        CustomLinkedList.printLinkedList(cll.head);

        System.out.println("Adding Cycle:");
        addRemoveLoop.addCycle(cll.head);

        //leads to indefinite printing due to presence of loop
        /*System.out.println("Printing Looped linked list:");
        LinkedList.printLinkedList(head);*/

        boolean loopPresent = addRemoveLoop.detectCycle(cll.head);
        System.out.println("Cycle present in the linked list : " + loopPresent);
        if(loopPresent){
            System.out.println("Removing Cycle:");
            addRemoveLoop.detectAndRemoveCycle(cll.head);
            System.out.println("Printing linked list:");
            CustomLinkedList.printLinkedList(cll.head);
        }
    }
}
