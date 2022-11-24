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

    public T deleteFirst(){
        if (head == null){
            throw new RuntimeException("LinkedList is empty");
        }
        T val = head.data;
        if (head == tail){
            head = null;
            tail = null;
        }else{
            head = head.next;
        }
        size--;
        return val;
    }

    public T delete(int index){
        if (index == 0){
            deleteFirst();
        }
        if (index == size-1){
            deleteLast();
        }
        Node prev = getByIndex(index-1);
        T val = (T) prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public T deleteLast(){
        if (size == 1){
            return deleteFirst();
        }
        Node secondLast = getByIndex(size-2);
        T val = tail.data;
        tail = secondLast;
        tail.next = head;
        size--;
        return val;
    }

    private Node getByIndex(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private static void printCircularSinglyLinkedList(Node head) {
        Node node = head;
        if (head != null){
            do {
                System.out.print(node.data + " -> ");
                node = node.next;
            }while (node != head);
        }
        System.out.println();
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
        cll.add(9, 1);
        printCircularSinglyLinkedList(cll.head);

        cll.deleteFirst();
        cll.delete(4);
        cll.deleteLast();
        printCircularSinglyLinkedList(cll.head);
    }
}
