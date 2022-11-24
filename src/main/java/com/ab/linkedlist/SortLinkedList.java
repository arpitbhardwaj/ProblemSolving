package com.ab.linkedlist;

public class SortLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(20);
        ll.addLast(21);
        ll.addLast(5);
        ll.addLast(10);
        ll.addLast(15);
        SinglyLinkedList.printLinkedList(ll.head);

        mergeSort(ll.head);
    }

    private static Node mergeSort(Node<Integer> head) {
        Node mid = SinglyLinkedList.getMiddleElement(head);
        Node left = mergeSort(head);
        Node right = mergeSort(mid);
        return merge(left,right);
    }

    private static Node merge(Node node1, Node node2) {
        return null;
    }

}
