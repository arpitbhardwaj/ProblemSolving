package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * In circular Singly linked list,
 * There is no null value present in the next part of any of the nodes.
 * The last node of the list contains a pointer to the first node of the list.
 */
public class SinglyCircularLinkedList<T> {

    Node last;

    public SinglyCircularLinkedList() {
        this.last = null;
    }

    public void addAtFront(T data) {
        if (last == null){
            addToEmpty(data);
        }

        Node node = new Node(data);
        node.next = last.next;
        last.next = node;
    }

    public void addAtEnd(T data) {
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

    public static void main(String[] args) {
        Node<Integer> last = getSampleCircularLinkedList();
        System.out.println("Printing Circular linked list:");
        printCircularLinkedList(last);
    }

    public static Node<Integer> getSampleCircularLinkedList() {
        SinglyCircularLinkedList<Integer> linkedList = new SinglyCircularLinkedList<>();
        linkedList.addAtEnd(1);
        linkedList.addAtEnd(2);
        linkedList.addAtEnd(3);
        linkedList.addAtEnd(4);
        linkedList.addAtFront(5);
        linkedList.addAtFront(6);
        return linkedList.last;
    }
}
