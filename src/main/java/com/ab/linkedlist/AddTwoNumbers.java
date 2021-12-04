package com.ab.linkedlist;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        CustomLinkedList<Integer> num1 = new CustomLinkedList<>();
        num1.addLast(3);
        num1.addLast(6);
        num1.addLast(5);
        CustomLinkedList.printLinkedList(num1.head);

        CustomLinkedList<Integer> num2 = new CustomLinkedList<>();
        num2.addLast(2);
        num2.addLast(4);
        num2.addLast(8);
        CustomLinkedList.printLinkedList(num2.head);


        Node head = sum(num1,num2);
        CustomLinkedList.printLinkedList(head);
    }

    private static Node sum(CustomLinkedList<Integer> num1, CustomLinkedList<Integer> num2) {

        Node<Integer> head1 = num1.head;
        Node<Integer> head2 = num2.head;

        CustomLinkedList<Integer> sum = new CustomLinkedList<>();
        //reverse linked list
        System.out.println("reverse linked list");
        num1.reverse();
        CustomLinkedList.printLinkedList(num1.head);
        num2.reverse();
        CustomLinkedList.printLinkedList(num2.head);

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
        sum.reverse();
        CustomLinkedList.printLinkedList(sum.head);
        return sum.head;
    }
}
