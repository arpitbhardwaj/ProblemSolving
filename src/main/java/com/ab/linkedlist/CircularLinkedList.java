package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * In Singly Circular linked list,
 * There is no null value present in the next part of any of the nodes.
 * The last node of the list contains a pointer to the first node of the list.
 *
 * In Doubly Circular linked list,
 * doesn't contain NULL in any of the node.
 * The last node of the list contains the address of the first node of the list.
 * The first node of the list also contain address of the last node in its previous pointer.
 */
public class CircularLinkedList<T> {

    Node last;

    public CircularLinkedList() {
        this.last = null;
    }

    public void addFront(T data) {
        if (last == null){
            addToEmpty(data);
        }

        Node node = new Node(data);
        node.next = last.next;
        last.next = node;
    }

    public void addLast(T data) {
        if (last == null){
            addToEmpty(data);
        }

        Node node = new Node(data);
        node.next = last.next;
        last.next = node;
        last = node;
    }

    public void addToEmpty(T data) {
        if (last != null){
            return;
        }
        Node node = new Node(data);
        last = node;
        last.next = last;
    }

    private static void printCircularLinkedList(Node last) {
        if (last == null){
            throw new IllegalStateException("List is Empty");
        }
        Node first = last.next;
        /*while (first != null){
            System.out.print(first.data);
            first = first.next;
            if(first != last.next){
                System.out.print(" -> ");
            }
            if (first == last.next){
                break;
            }
        }*/
        do {
            System.out.print(first.data);
            first = first.next;
            if(first != last.next){
                System.out.print(" -> ");
            }
        }while (first != last.next);

        System.out.println();
    }

    public static Node<Integer> getSampleCircularLinkedList() {
        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addFront(5);
        linkedList.addFront(6);
        return linkedList.last;
    }

    public static void main(String[] args) {
        Node<Integer> last = getSampleCircularLinkedList();
        System.out.println("Printing Circular linked list:");
        printCircularLinkedList(last);
    }
}
