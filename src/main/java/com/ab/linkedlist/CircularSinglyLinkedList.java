package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * In Circular Singly linked list,
 * doesn't contain NULL in any of the node.
 * The last node of the list contains a pointer to the first node of the list.
 *
 */
public class CircularSinglyLinkedList<T> {
    Node head;
    Node tail;

    public CircularSinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addLast(T data) {
        Node node = new Node(data);
        if (head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(T val){
        Node node = head;
        if (node == null){
            return;
        }
        if (node.data == val){
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node n =node.next;
            if (n.data == val){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while (node!= head);
    }

    private static void printCircularLinkedList(Node head) {
        Node node = head;
        if (head != null){
            do {
                System.out.print(node.data + " -> ");
                node = node.next;
            }while (node != head);
        }
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList<Integer> cll = new CircularSinglyLinkedList<>();
        cll.addLast(1);
        cll.addLast(2);
        cll.addLast(3);
        cll.addLast(6);
        cll.addLast(4);
        cll.addLast(5);
        cll.delete(4);
        System.out.println("Printing Circular Singly linked list:");
        printCircularLinkedList(cll.head);
    }
}
