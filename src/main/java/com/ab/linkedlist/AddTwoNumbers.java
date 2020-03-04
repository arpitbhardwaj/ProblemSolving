package com.ab.linkedlist;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        LinkedList<Integer> num1 = new LinkedList<>();
        Node head1 = null;
        //head1 = num1.add(9,head1);
        head1 = num1.add(3,head1);
        head1 = num1.add(6,head1);
        head1 = num1.add(5,head1);

        LinkedList.printLinkedList(head1);

        LinkedList<Integer> num2 = new LinkedList<>();
        Node head2 = null;
        head2 = num2.add(2,head2);
        //head2 = num2.add(6,head2);
        head2 = num2.add(4,head2);
        head2 = num2.add(8,head2);

        LinkedList.printLinkedList(head2);

        LinkedList<Integer> sum = new LinkedList<>();

        Node head = sum(num1,num2,head1,head2,sum);

        LinkedList.printLinkedList(head);
    }

    private static Node sum(LinkedList<Integer> num1, LinkedList<Integer> num2, Node<Integer> head1, Node<Integer> head2, LinkedList<Integer> sum) {
        //reverse linked list
        System.out.println("reverse linked list");
        head1 = num1.reverse(head1);
        LinkedList.printLinkedList(head1);
        head2 = num2.reverse(head2);
        LinkedList.printLinkedList(head2);

        //Add the nodes of both the lists iteratively.
        int carry = 0;
        int totalSum = 0;

        Node<Integer> sumHead = head1;
        Node<Integer> prev = null;
        while (head1 != null && head2 != null){
            totalSum = carry + head1.data + head2.data;
            head1.data = Utils.getLSD(totalSum);
            carry  = Utils.getWithoutLSD(totalSum);
            prev = head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        //Add the remaining node
        if(head1 != null && head2 != null){
            if (head2 != null){
                prev.next = head2;
            }
            head1 = prev.next;
            while (head1 != null){
                totalSum = carry + head1.data;
                head1.data = Utils.getLSD(totalSum);
                carry  = Utils.getWithoutLSD(totalSum);
                prev = head1;
                head1 = head1.next;
            }
        }

        //if still carry left then add it as a new node at the end
        if (carry > 0){
            prev.next = new Node(carry);
        }
        //Reverse the resultant list and return its head.
        return sum.reverse(sumHead);
    }
}
