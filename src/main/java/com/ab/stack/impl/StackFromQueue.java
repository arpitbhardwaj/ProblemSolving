package com.ab.stack.impl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A stack can be implemented using two queues.
 * Method 1 (By making push operation costly)
 * Method 2 (By making pop operation costly)
 *
 * @author Arpit Bhardwaj
 */
public class StackFromQueue {

    public static void main(String[] args) {
        CustomStack<Integer> customStack = new CustomStack<>();
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);

        System.out.println("Size of Stack : " + customStack.size());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println("Size of Stack : " + customStack.size());
    }

    private static class CustomStack<T> {
        static int size;
        Queue<T> queue1;
        Queue<T> queue2;

        public CustomStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
            size=0;
        }

        public void push(T i) {
            size++;
            queue2.add(i);
            while (!queue1.isEmpty()){
                queue2.add(queue1.poll());
            }

            //swap the queues
            Queue queue = queue1;
            queue1 = queue2;
            queue2 = queue;
        }

        public int size() {
            return size;
        }

        public T pop() {
            if(queue1.isEmpty()){
                throw new IllegalStateException("Stack is Empty");
            }
            size--;
            return queue1.poll();
        }
    }
}
