package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class MergeLinkedList<T> {
    public static void main(String[] args) {
        int k = 3;
        Node[] nodeArr = new Node[k];

        CustomLinkedList<Integer> customLinkedList1 = new CustomLinkedList<>();
        Node<Integer> head1 = null;
        head1 = customLinkedList1.add(5,head1);
        head1 = customLinkedList1.add(10,head1);
        head1 = customLinkedList1.add(15,head1);
        CustomLinkedList.printLinkedList(head1);

        CustomLinkedList<Integer> customLinkedList2 = new CustomLinkedList<>();
        Node<Integer> head2 = null;
        head2 = customLinkedList2.add(2,head2);
        head2 = customLinkedList2.add(3,head2);
        head2 = customLinkedList2.add(20,head2);
        head2 = customLinkedList2.add(21,head2);
        CustomLinkedList.printLinkedList(head2);

        CustomLinkedList<Integer> customLinkedList3 = new CustomLinkedList<>();
        Node<Integer> head3 = null;
        head3 = customLinkedList3.add(6,head3);
        head3 = customLinkedList3.add(9,head3);
        head3 = customLinkedList3.add(11,head3);
        head3 = customLinkedList3.add(51,head3);
        CustomLinkedList.printLinkedList(head3);

        /*Node head = merge.mergeTwoSortedList(head1,head2);
        LinkedList.printLinkedList(head);*/

        nodeArr[0] = head1;
        nodeArr[1] = head2;
        nodeArr[2] = head3;
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
