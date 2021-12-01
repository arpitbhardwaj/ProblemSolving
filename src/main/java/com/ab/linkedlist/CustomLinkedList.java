package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class CustomLinkedList<T> {

    public Node<T> head;
    public Node<T> tail;
    private int size;

    public CustomLinkedList() {
        this.size=0;
    }

    public void addFirst(T data){
        Node node = new Node(data);
        node.next = head;
        head = node;

        if (tail==null){
            tail = head;
        }
        size++;
    }

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
        if (tail==null){
            addFirst(data);
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        tail = node;
        size++;
    }

    public T deleteFirst() {
        T val = head.data;
        head = head.next;
        if (head==null){
            tail = null;
        }
        size--;
        return val;
    }

    public T delete(int index){
        if (index==0){
            deleteFirst();
        }
        if (index==size-1){
            deleteLast();
        }
        Node prev = getByIndex(index-1);
        T val = (T) prev.next.data;
        prev.next = prev.next.next;
        return val;
    }

    public T deleteLast(){
        if (size==1){
            return deleteFirst();
        }
        Node secondLast = getByIndex(size-2);
        T val = tail.data;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public void reverse(){
        Node previous = null;
        Node current = head;
        Node next = null;

        while (current != null){
            //store current.next before changing
            next = current.next;
            //change current.next to previous
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void recursiveReverse(){
        if(head == null || head.next == null){
            return ;
        }
        recursiveReverse();
        head.next.next = head;
        head.next = null;
    }

    public Node getByVal(T data){
        Node temp = head;
        while (temp != null){
            if(temp.data == data){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Node getByIndex(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static int getSize(Node head) {
        Node current = head;
        int count = 0;
        while (current != null){
            current = current.next;
            count++;
        }
        return count;
    }

    public static void printLinkedList(Node head) {
        while (head != null){
            System.out.print(head.data);
            head = head.next;
            if(head != null){
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        System.out.println("Printing linked list:");
        CustomLinkedList.printLinkedList(ll.head);

        ll.addFirst(0);
        ll.add(11,3);
        CustomLinkedList.printLinkedList(ll.head);

        ll.deleteFirst();
        ll.deleteLast();
        ll.delete(3);
        CustomLinkedList.printLinkedList(ll.head);

        Node findNode = ll.getByVal(11);
        System.out.println("Finding Node 11 : " + findNode.data);

        ll.reverse();
        System.out.println("Printing reverse linked list:");
        CustomLinkedList.printLinkedList(ll.head);


        /*ll.recursiveReverse();
        System.out.println("Printing reverse linked list:");
        CustomLinkedList.printLinkedList(ll.head);*/
    }
}
