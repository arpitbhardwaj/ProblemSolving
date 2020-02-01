package com.ab.linkedlist;

import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class LinkedList<T> {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Node<Integer> head = linkedList.getSampleLinkedList();
        System.out.println("Printing linked list:");
        printLinkedList(head);
        System.out.println("Adding 0 at front in linked list:");
        head = linkedList.addAtFront(0,head);
        printLinkedList(head);
        Node findNode = linkedList.find(head,4);
        System.out.println("Finding Node 4 : " + findNode.data);
        //head = linkedList.reverse(head);
        head = linkedList.recursiveReverse(head);
        System.out.println("Printing reverse linked list:");
        printLinkedList(head);
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
        LinkedList<T> linkedList = new LinkedList<>();
        Node head = null;
        head = linkedList.add(1,head);
        head = linkedList.add(2,head);
        head = linkedList.add(3,head);
        head = linkedList.add(4,head);
        head = linkedList.add(5,head);
        head = linkedList.add(6,head);
        return head;
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

    public Node<T> addAtFront(T data, Node head){
        Node node = new Node(data);
        if(head == null){
            return node;
        }
        node.next = head;
        return node;
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

    public Node recursiveReverseEasy(Node head){
        return null;
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
}
