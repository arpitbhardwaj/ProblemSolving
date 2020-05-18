package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class Merge<T> {
    public static void main(String[] args) {
        int k = 3;
        Merge<Integer> merge = new Merge();
        Node[] nodeArr = new Node[k];

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

        nodeArr[0] = head1;
        nodeArr[1] = head2;
        nodeArr[2] = head3;
        Node resultHead = merge.mergeKSortedList(nodeArr);
        LinkedList.printLinkedList(resultHead);
    }

    private Node<Integer> mergeTwoSortedList(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }

        if (head1.data < head2.data){
            head1.next = mergeTwoSortedList(head1.next,head2);
            return head1;
        }
        else {
            head2.next = mergeTwoSortedList(head1,head2.next);
            return head2;
        }
    }

    private Node<Integer> mergeKSortedList(Node arr[]) {
        int last = arr.length - 1;

        while (last != 0){
            int i = 0,j = last;
            for (;i < j;) {
                arr[i] = mergeTwoSortedList(arr[i],arr[j]);
                i++;j--;
                if (i >= j){
                    last = j;
                }
            }
        }

        return arr[0];
    }
}
