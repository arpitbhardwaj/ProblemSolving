package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class MergeLinkedList{
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

        Node resultHead = mergeKSortedList(new Node[]{cll1.head,cll2.head,cll3.head});
        SinglyLinkedList.printLinkedList(resultHead);
    }

    //this can efficiently be done using heap (priority queue)
    private static Node<Integer> mergeKSortedList(Node lists[]) {
        int k = lists.length;

        if(k==0){
            return null;
        }

        Node sortedHead = lists[0];
        for(int i = 1; i < k; i++){
            //sortedHead = mergeTwoSortedListRecursive(sortedHead,lists[i]);
            sortedHead = mergeTwoSortedList(sortedHead,lists[i]);
        }
        return sortedHead;
    }

    private static Node<Integer> mergeTwoSortedListRecursive(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }

        if (head1.data < head2.data){
            head1.next = mergeTwoSortedListRecursive(head1.next,head2);
            return head1;
        }
        else {
            head2.next = mergeTwoSortedListRecursive(head1,head2.next);
            return head2;
        }
    }

    private static Node<Integer> mergeTwoSortedList(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> f = head1;
        Node<Integer> s = head2;

        SinglyLinkedList<Integer> resList = new SinglyLinkedList<>();
        while (f!= null && s != null){
            if (f.data < s.data){
                resList.addLast(f.data);
                f = f.next;
            }else {
                resList.addLast(s.data);
                s = s.next;
            }
        }

        while (f != null){
            resList.addLast(f.data);
            f = f.next;
        }
        while (s != null){
            resList.addLast(s.data);
            s = s.next;
        }
        return resList.head;
    }

}
