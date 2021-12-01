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
        temp.next = node;
        size++;
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

    public Node find(T data){
        Node temp = head;
        while (temp != null){
            if(temp.data == data){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static int getNodeCounts(Node head) {
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

        System.out.println("Adding 0 at front in linked list:");
        ll.addFirst(0);
        CustomLinkedList.printLinkedList(ll.head);

        Node findNode = ll.find(4);
        System.out.println("Finding Node 4 : " + findNode.data);

        ll.reverse();
        System.out.println("Printing reverse linked list:");
        CustomLinkedList.printLinkedList(ll.head);

        /*ll.recursiveReverse();
        System.out.println("Printing reverse linked list:");
        CustomLinkedList.printLinkedList(ll.head);*/
    }
}
