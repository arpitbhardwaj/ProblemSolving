package com.ab.heap;

import com.ab.linkedlist.impl.SinglyLinkedList;
import com.ab.linkedlist.impl.Node;

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
        SinglyLinkedList<Integer> cll1 = new SinglyLinkedList<>();
        cll1.addLast(5);
        cll1.addLast(10);
        cll1.addLast(15);
        SinglyLinkedList.printLinkedList(cll1.head);

        SinglyLinkedList<Integer> cll2 = new SinglyLinkedList<>();
        cll2.addLast(2);
        cll2.addLast(3);
        cll2.addLast(20);
        cll2.addLast(21);
        SinglyLinkedList.printLinkedList(cll2.head);

        SinglyLinkedList<Integer> cll3 = new SinglyLinkedList<>();
        cll3.addLast(6);
        cll3.addLast(9);
        cll3.addLast(11);
        cll3.addLast(51);
        SinglyLinkedList.printLinkedList(cll3.head);

        Node<Integer> resultHead = mergeKLinkedLists(List.of(cll1.head,cll2.head,cll3.head));
        SinglyLinkedList.printLinkedList(resultHead);
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
