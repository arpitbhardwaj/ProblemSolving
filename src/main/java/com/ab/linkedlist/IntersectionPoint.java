package com.ab.linkedlist;

import com.ab.linkedlist.impl.Node;
import com.ab.linkedlist.impl.SinglyLinkedList;

/**
 * @author Arpit Bhardwaj
 */
public class IntersectionPoint {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> ll1 = new SinglyLinkedList<>();
        ll1.addLast(1);
        ll1.addLast(2);
        ll1.addLast(3);
        ll1.addLast(4);
        ll1.addLast(5);
        ll1.addLast(6);

        SinglyLinkedList<Integer> ll2 = new SinglyLinkedList<>();
        ll2.addLast(10);
        ll2.addLast(4);
        ll2.addLast(5);
        ll2.addLast(6);

        SinglyLinkedList.printLinkedList(ll1.head);
        SinglyLinkedList.printLinkedList(ll2.head);

        Node intersectionNode = getIntersection(ll1.head,ll2.head);
        System.out.println("intersection Point is : "+ intersectionNode.data);
    }

    private static Node getIntersection(Node head1, Node head2) {
        int count1 = SinglyLinkedList.getSize(head1);
        int count2 = SinglyLinkedList.getSize(head2);
        int difference = 0;
        Node intersectionNode = null;
        if (count1 > count2){
            difference = count1 - count2;
            intersectionNode = getIntersectionUtil(difference,head1,head2);
        }
        else{
            difference = count2 - count1;
            intersectionNode = getIntersectionUtil(difference,head2,head1);
        }
        return intersectionNode;
    }

    private static Node getIntersectionUtil(int difference, Node largerHead, Node smallerHead) {
        Node largerCurrent = largerHead;
        Node smallerCurrent = smallerHead;

        for (int i = 0; i < difference; i++) {
            if (largerCurrent != null){
                largerCurrent = largerCurrent.next;
            }
        }

        while (largerCurrent != null
        && smallerCurrent != null){
            if (largerCurrent.data == smallerCurrent.data){
                return largerCurrent;
            }
            largerCurrent = largerCurrent.next;
            smallerCurrent = smallerCurrent.next;
        }
        return null;
    }
}
