package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class MergeLinkedList<T> {
    public static void main(String[] args) {
        CustomLinkedList<Integer> cll1 = new CustomLinkedList<>();
        cll1.addLast(5);
        cll1.addLast(10);
        cll1.addLast(15);
        CustomLinkedList.printLinkedList(cll1.head);

        CustomLinkedList<Integer> cll2 = new CustomLinkedList<>();
        cll2.addLast(2);
        cll2.addLast(3);
        cll2.addLast(20);
        cll2.addLast(21);
        CustomLinkedList.printLinkedList(cll2.head);

        CustomLinkedList<Integer> cll3 = new CustomLinkedList<>();
        cll3.addLast(6);
        cll3.addLast(9);
        cll3.addLast(11);
        cll3.addLast(51);
        CustomLinkedList.printLinkedList(cll3.head);

        /*Node head = merge.mergeTwoSortedList(head1,head2);
        LinkedList.printLinkedList(head);*/

        int k = 3;
        Node[] nodeArr = new Node[k];
        nodeArr[0] = cll1.head;
        nodeArr[1] = cll2.head;
        nodeArr[2] = cll3.head;
        Node resultHead = mergeKSortedList(nodeArr);
        CustomLinkedList.printLinkedList(resultHead);
    }

    //this can efficiently be done using heap (priority queue)
    private static Node<Integer> mergeKSortedList(Node lists[]) {
        int k = lists.length;

        if(k==0){
            return null;
        }

        Node sortedHead = lists[0];
        for(int i = 1; i < k; i++){
            sortedHead = mergeTwoSortedList(sortedHead,lists[i]);
        }

        return sortedHead;
    }

    private static Node<Integer> mergeTwoSortedList(Node<Integer> head1, Node<Integer> head2) {
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

}
