package com.ab.heap;

import com.ab.linkedlist.LinkedList;
import com.ab.linkedlist.Node;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Arpit Bhardwaj
 *
 * Given K sorted linked lists of different sizes.
 * The task is to merge them in such a way that after merging they will be a single sorted linked list.
 */
public class MergeKLinkedList{
    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        Node<Integer> head1 = null;
        head1 = linkedList1.add(5,head1);
        head1 = linkedList1.add(10,head1);
        head1 = linkedList1.add(15,head1);
        LinkedList.printLinkedList(head1);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        Node<Integer> head2 = null;
        head2 = linkedList2.add(2,head2);
        head2 = linkedList2.add(3,head2);
        head2 = linkedList2.add(20,head2);
        head2 = linkedList2.add(21,head2);
        LinkedList.printLinkedList(head2);

        LinkedList<Integer> linkedList3 = new LinkedList<>();
        Node<Integer> head3 = null;
        head3 = linkedList3.add(6,head3);
        head3 = linkedList3.add(9,head3);
        head3 = linkedList3.add(11,head3);
        head3 = linkedList3.add(51,head3);
        LinkedList.printLinkedList(head3);

        /*Node head = merge.mergeTwoSortedList(head1,head2);
        LinkedList.printLinkedList(head);*/


        Node<Integer> resultHead = mergeKLinkedLists(List.of(head1,head2,head3));
        LinkedList.printLinkedList(resultHead);

    }

    public static Node<Integer> mergeKLinkedLists(List<Node<Integer>> lists){
        if (lists == null || lists.size() == 0)
            return null;

        PriorityQueue<Node<Integer>> q = new PriorityQueue<>(lists.size(), new Comparator<Node<Integer>>() {
            @Override
            public int compare(Node<Integer> o1, Node<Integer> o2) {
                if (o1.data < o2.data){
                    return -1;
                }else if (o1.data > o2.data){
                    return 1;
                }
                return 0;
            }
        });

        Node<Integer> dummy = new Node<>(0);
        Node<Integer> tail = dummy;

        for (Node<Integer> node:
             lists) {
            if (node != null){
                q.add(node);
            }
        }

        while (!q.isEmpty()){
            tail.next = q.poll();
            tail = tail.next;

            if (tail.next != null){
                q.add(tail.next);
            }
        }

        return dummy.next;
    }
}
