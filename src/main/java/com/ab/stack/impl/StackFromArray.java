package com.ab.stack.impl;

import java.util.Arrays;

public class StackFromArray {

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(4);
        stack.push(11);
        stack.push(20);
        stack.push(3);
        stack.printStack();

        System.out.println(stack.pop());
        stack.push(23);
        stack.push(12);
        stack.printStack();

        System.out.println(stack.peek());
        stack.delete();
        stack.printStack();
    }

    private static class CustomStack {
        int arr[];
        int topOfStack;

        public CustomStack(int size) {
            this.arr = new int[size];
            this.topOfStack = -1;
        }

        public boolean isEmpty(){
            return topOfStack == -1;
        }

        public boolean isFull(){
            return topOfStack == arr.length-1;
        }

        public void push(int data) {
            if (!isFull()){
                topOfStack++;
                arr[topOfStack] = data;
            }
        }

        public int pop() {
            if (!isEmpty()){
                return arr[topOfStack--];
            }
            return -1;
        }

        public int peek() {
            if (!isEmpty()){
                return arr[topOfStack];
            }
            return -1;
        }

        public void delete() {
            arr = null;
        }

        public void printStack(){
            System.out.println(Arrays.toString(arr));
        }
    }
}
