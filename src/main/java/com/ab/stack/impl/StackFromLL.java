package com.ab.stack.impl;

import java.util.Arrays;
import java.util.LinkedList;

public class StackFromLL {
    public static void main(String[] args) {
        CustomStack<Integer> customStack = new CustomStack<>();
        customStack.push(11);
        customStack.push(20);
        customStack.push(3);
        customStack.printStack();

        System.out.println(customStack.pop());
        customStack.push(23);
        customStack.push(12);
        customStack.printStack();

        System.out.println(customStack.peek());
        customStack.delete();
        customStack.printStack();
    }

    private static class CustomStack<T> {
        LinkedList<T> ll;

        public CustomStack() {
            ll = new LinkedList<>();
        }

        public boolean isEmpty(){
            return ll.isEmpty();
        }

        public void push(T i) {
            ll.addFirst(i);
        }

        public T pop() {
            return ll.removeFirst();
        }

        public T peek() {
            return ll.peekFirst();
        }

        public void delete() {
            ll.clear();
        }

        public void printStack(){
            for (T item : ll) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
