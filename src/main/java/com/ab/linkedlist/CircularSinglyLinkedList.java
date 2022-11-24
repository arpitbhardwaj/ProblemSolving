package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * Doesn't contain NULL in any of the node.
 * The last node of the list contains a pointer to the first node of the list.
 */
public class CircularSinglyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public CircularSinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private void initialize(Node node){
        node.next = node;
        head = node;
        tail = node;
    }

    public void addFirst(T data) {
        Node node = new Node(data);
        if(head == null){
            initialize(node);
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public void add(T data, int index) {
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

    public void addLast(T data) {
        Node node = new Node(data);
        if (head == null){
            initialize(node);
        }else{
            tail.next = node;
            node.next = head;
            tail = node;
        }
        size++;
    }

    public void deleteFirst(){
        size--;
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

    public void deleteLast(){
        size--;
    }

    private static void printCircularSinglyLinkedList(Node head) {
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
        cll.addFirst(0);
        cll.addLast(3);
        cll.addLast(6);
        cll.addLast(4);
        cll.addLast(5);
        cll.delete(4);
        cll.add(9, 1);
        printCircularSinglyLinkedList(cll.head);
    }
}
