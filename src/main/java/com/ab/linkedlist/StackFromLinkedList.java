package com.ab.linkedlist;

import com.ab.linkedlist.impl.Node;
import com.ab.linkedlist.impl.SinglyLinkedList;

/**
 * @author Arpit Bhardwaj
 */
public class StackFromLinkedList<T> {
    Node<T> top;

    public StackFromLinkedList() {
        this.top = null;
    }

    public void push(T item) {
        Node<T> node = new Node<>(item);
        //push the node at the head of linked list
        node.next = top;
        top = node;
    }

    private void pop() {
        if (top == null){
            throw new IllegalStateException("Stack is Empty");
        }
        //pop the element from the head of the linked list
        top = top.next;
    }

    public void display() {
        SinglyLinkedList.printLinkedList(top);
    }
    public static void main(String[] args) {
        StackFromLinkedList<Integer> stack = new StackFromLinkedList<>();
        stack.push(12);
        stack.push(14);
        stack.push(25);
        stack.push(9);

        stack.display();

        stack.pop();
        stack.pop();

        stack.display();
    }

}
