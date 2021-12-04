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
        CustomLinkedList<Integer> cll = new CustomLinkedList<>();
        cll.addLast(1);
        cll.addLast(2);
        cll.addLast(3);
        cll.addLast(11);
        cll.addLast(4);
        cll.addLast(5);
        cll.addLast(6);
        System.out.println("Printing linked list:");
        CustomLinkedList.printLinkedList(cll.head);

        Node<Integer> middleNode = getMiddleElement(cll.head);
        System.out.println("Middle node : " + middleNode.data);
    }

    private static Node<Integer> getMiddleElement(Node<Integer> head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
