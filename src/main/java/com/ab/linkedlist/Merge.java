package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class Merge<T> {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        Node<Integer> head1 = null;
        head1 = linkedList1.add(5,head1);
        head1 = linkedList1.add(10,head1);
        head1 = linkedList1.add(15,head1);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        Node<Integer> head2 = null;
        head2 = linkedList2.add(2,head2);
        head2 = linkedList2.add(3,head2);
        head2 = linkedList2.add(20,head2);
        head2 = linkedList2.add(21,head2);

        Merge<Integer> merge = new Merge();
        Node head = merge.mergeSortedList(head1,head2);
        LinkedList.printLinkedList(head);
    }

    private Node<Integer> mergeSortedList(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }

        if (head1.data < head2.data){
            head1.next = mergeSortedList(head1.next,head2);
            return head1;
        }
        else {
            head2.next = mergeSortedList(head1,head2.next);
            return head2;
        }
    }
}
