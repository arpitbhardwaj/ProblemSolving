package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class DoublyLinkedList<T> {
    Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    //add at front of linked list //5 Step Process
    public void addFirst(T data){
        Node<T> node = new Node<>(data);
        if (this.head == null){
            addToEmpty(data);
            return;
        }
        node.next = head;
        head.before = node;
        head = node;
    }

    //add node after a given node //7 Step Process
    public void add(Node prevNode, T data){}

    //add node at end of linked list //7 Step Process
    public void addLast(T data){
        Node<T> node = new Node<>(data);
        if (this.head == null){
            addToEmpty(data);
            return;
        }

        Node current = this.head;
        while (current.next != null){
            current = current.next;
        }
        current.next = node;
        node.before = current;
    }

    public void addToEmpty(T data) {
        if (this.head != null){
            return;
        }
        Node node = new Node(data);
        this.head = node;
    }

    private static void printDoublyLinkedList(Node head) {
        Node last = null;
        System.out.println("Printing in forward direction");
        while (head != null){
            last = head;
            System.out.print(head.data);
            head = head.next;
            if(head != null){
                System.out.print(" -> ");
            }
        }
        System.out.println();
        System.out.println("Printing in reverse direction");
        while (last != null){
            System.out.print(last.data);
            last = last.before;
            if(last != null){
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static Node<Integer> getSampleDoublyLinkedList() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addFirst(5);
        linkedList.addFirst(6);
        return linkedList.head;
    }

    public static void main(String[] args) {
        Node<Integer> head = getSampleDoublyLinkedList();
        printDoublyLinkedList(head);
    }
}
