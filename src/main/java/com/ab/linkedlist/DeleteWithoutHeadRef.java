package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * You are given a singly linked list and pointer which is pointing to the node which is required to be deleted.
 * Any information about head pointer or any other node is not given.
 * You need to write a function to delete that node from linked list.
 *
 */
public class DeleteWithoutHeadRef {
    public static void main(String[] args) {
        CustomLinkedList<Integer> cll = new CustomLinkedList<>();
        cll.addLast(1);
        cll.addLast(2);
        cll.addLast(3);
        cll.addLast(4);
        cll.addLast(5);
        cll.addLast(6);
        System.out.println("Printing linked list:");
        CustomLinkedList.printLinkedList(cll.head);

        Node<Integer> nodeToDelete = cll.head.next.next.next;

        deleteWithoutHeadRef(nodeToDelete);
        System.out.println("Printing linked list:");
        CustomLinkedList.printLinkedList(cll.head);
    }

    private static void deleteWithoutHeadRef(Node<Integer> nodeToDelete) {
        if(nodeToDelete == null){
            throw new IllegalArgumentException("Empty Linked List");
        }else if(nodeToDelete.next == null){
            throw new IllegalStateException("This is Last Node, Head is required to delete");
        }

        nodeToDelete.data = (Integer) nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;
    }
}
