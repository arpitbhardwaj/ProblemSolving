package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class CustomLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomLinkedList() {
        this.size=0;
    }

    public <T> Node<T> add(T data, Node head) {
        Node<T> tempHead = head;
        Node<T> node = new Node(data);
        if(head == null){
            return node;
        }
        while (head.next != null){
            head = head.next;
        }
        head.next = node;
        return tempHead;
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

    public Node<T> reverse(Node head){
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
        return head;
    }

    public Node<T> recursiveReverse(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node reversedList = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversedList;
    }

    public Node find(Node head, T data){
        while (head != null){
            if(head.data == data){
                return head;
            }
            head = head.next;
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

    public Node<T> getSampleLinkedList() {
        CustomLinkedList<T> customLinkedList = new CustomLinkedList<>();
        Node head = null;
        head = customLinkedList.add(1,head);
        head = customLinkedList.add(2,head);
        head = customLinkedList.add(3,head);
        head = customLinkedList.add(4,head);
        head = customLinkedList.add(5,head);
        head = customLinkedList.add(6,head);
        return head;
    }

    public Node<T> getCharacterLinkedList() {
        CustomLinkedList<T> customLinkedList = new CustomLinkedList<>();
        Node head = null;
        head = customLinkedList.add('a',head);
        head = customLinkedList.add('b',head);
        head = customLinkedList.add('c',head);
        head = customLinkedList.add('b',head);
        head = customLinkedList.add('a',head);
        return head;
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        Node<Integer> head = customLinkedList.getSampleLinkedList();
        System.out.println("Printing linked list:");
        printLinkedList(head);
        System.out.println("Adding 0 at front in linked list:");
        customLinkedList.addFirst(0);
        printLinkedList(head);
        Node findNode = customLinkedList.find(head,4);
        System.out.println("Finding Node 4 : " + findNode.data);
        //head = linkedList.reverse(head);
        head = customLinkedList.recursiveReverse(head);
        System.out.println("Printing reverse linked list:");
        printLinkedList(head);
    }
}
