package com.ab.queue.impl;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * A queue can be implemented using two stacks.
 * Method 1 (By making enQueue operation costly)
 * Method 2 (By making deQueue operation costly)
 *
 * @author Arpit Bhardwaj
 */
public class QueueFromStack {

    public static void main(String[] args) {
        CustomQueue<Integer> customQueue = new CustomQueue<>();
        Queue<Integer> queue = new ArrayDeque<>();
        customQueue.enQueue(1);
        customQueue.enQueue(2);
        customQueue.enQueue(3);
        customQueue.enQueue(4);

        System.out.println(customQueue.deQueue());
        System.out.println(customQueue.deQueue());
        System.out.println(customQueue.deQueue());
        System.out.println(customQueue.deQueue());
    }

    private static class CustomQueue<T> {

        Stack<T> stack1 = new Stack<>();
        Stack<T> stack2 = new Stack<>();

        public void enQueue(T i) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack1.push(i);
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }

        public T deQueue() {
            if(stack1.isEmpty()){
                //as this is an unchecked exception, hence no compile time error
                //no need to surround by try catch or put throws
                throw new IllegalStateException("Queue is Empty");
            }
            T x = stack1.pop();
            return x;
        }
    }
}
