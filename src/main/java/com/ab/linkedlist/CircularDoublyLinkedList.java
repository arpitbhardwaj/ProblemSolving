package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * Doesn't contain NULL in any of the node.
 * The last node of the list contains the address of the first node of the list.
 * The first node of the list also contain address of the last node in its previous pointer.
 */
public class CircularDoublyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public CircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private void initialize(Node node){
        node.next = node;
        node.before = node;
        head = node;
        tail = node;
    }


    public void addFirst(T data) {
        Node node = new Node(data);
        if(head == null){
            initialize(node);
        }else{
            node.next = head;
            node.before = tail;
            head.before = node;
            tail.next = node;
            head = node;
        }
        size++;
    }

    public void add(T data, int index) {
        if (index == 0){
            addFirst(data);
            return;
        }
        if (index == size){
            addLast(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(data);
        node.next = temp.next;
        node.before = temp;
        temp.next.before = node;
        temp.next = node;
        size++;
    }

    public void addLast(T data) {
        Node node = new Node(data);
        if (head == null){
            initialize(node);
        }else{
            node.next = head;
            node.before = tail;
            head.before = node;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void deleteFirst(T val){
        //TODO
    }

    public void delete(T val){
        //TODO
    }

    public void deleteLast(T val){
        //TODO
    }

    private static void printCircularDoublyLinkedList(Node head) {
        Node node = head;
        if (head != null){
            do {
                System.out.print(node.data + " -> ");
                node = node.next;
            }while (node != head);
        }
        System.out.println();
    }

    private static void printCircularDoublyLinkedListInReverse(Node tail) {
        Node node = tail;
        if (tail != null){
            do {
                System.out.print(node.data + " -> ");
                node = node.before;
            }while (node != tail);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> cdll = new CircularDoublyLinkedList<>();
        cdll.addLast(1);
        cdll.addLast(2);
        cdll.addFirst(0);
        cdll.addLast(3);
        cdll.addLast(6);
        cdll.addLast(4);
        cdll.addLast(5);
        cdll.add(9, 1);
        printCircularDoublyLinkedList(cdll.head);
        printCircularDoublyLinkedListInReverse(cdll.tail);
    }
}
