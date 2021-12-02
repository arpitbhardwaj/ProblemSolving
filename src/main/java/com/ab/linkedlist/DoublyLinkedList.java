package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class DoublyLinkedList<T> {
    Node head;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.size=0;
    }

    public void addFirst(T data){
        Node node = new Node(data);
        node.next = head;
        node.before = null;
        if (head != null){
            head.before = node;
        }
        head = node;
        size++;
    }

    //exactly same as simple linked list
    public void add(T data,int index) {
        if (index==0){
            addFirst(data);
            return;
        }
        if (index==size){
            addLast(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void addLast(T data){
        Node node = new Node(data);
        node.next = null;

        if (head == null){
            addFirst(data);
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.before = temp;
        size++;
    }

    private static void printDoublyLinkedList(Node head) {
        System.out.println("Printing in forward direction");
        while (head != null){
            System.out.print(head.data);
            head = head.next;
            if(head != null){
                System.out.print(" -> ");
            }
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addFirst(5);
        dll.addFirst(6);
        dll.add(11,4);
        printDoublyLinkedList(dll.head);
    }
}
