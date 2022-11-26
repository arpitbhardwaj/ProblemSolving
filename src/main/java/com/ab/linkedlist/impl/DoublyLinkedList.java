package com.ab.linkedlist.impl;

/**
 * @author Arpit Bhardwaj
 */
public class DoublyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size=0;
    }

    public void addFirst(T data){
        Node node = new Node(data);
        node.next = head;
        node.before = null;
        if(head != null){
            head.before = node;
        }
        head = node;
        if (tail == null){
            tail = node;
        }
        size++;
    }

    public void add(T data,int index) {
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

    public void addLast(T data){
        if (tail == null){
            addFirst(data);
            return;
        }

        Node node = new Node(data);
        node.before = tail;
        node.next = null;
        tail.next = node;
        tail = node;
        size++;
    }

    public T deleteFirst(){
        if (head == null){
            throw new RuntimeException("LinkedList is empty");
        }
        T val = head.data;
        head = head.next;
        if (head == null){
            tail = null;
        }else{
            head.before = null;
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
        prev.next.before = prev;
        size--;
        return val;
    }

    public T deleteLast(){
        if (size == 1){
            return deleteFirst();
        }
        T val = tail.data;
        tail = tail.before;
        tail.next = null;
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

    private static void printDoublyLinkedList(Node head) {
        while (head != null){
            System.out.print(head.data);
            head = head.next;
            if(head != null){
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    private static void printDoublyLinkedListInReverse(Node tail) {
        while (tail != null){
            System.out.print(tail.data);
            tail = tail.before;
            if(tail != null){
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public void deleteDoublyLinkedList(){
        Node temp = head;
        while (temp != null){
            temp.before = null;
            temp = temp.next;
        }
        head = null;
        tail = null;
    }

    public static void main(String[] args) throws InterruptedException {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addFirst(5);
        dll.addFirst(6);
        dll.add(11,4);
        printDoublyLinkedList(dll.head);
        printDoublyLinkedListInReverse(dll.tail);

        dll.deleteFirst();
        dll.deleteLast();
        dll.delete(2);
        printDoublyLinkedList(dll.head);
        printDoublyLinkedListInReverse(dll.tail);

        dll.deleteDoublyLinkedList();
        Thread.sleep(1000);
        SinglyLinkedList.printLinkedList(dll.head);
    }
}
