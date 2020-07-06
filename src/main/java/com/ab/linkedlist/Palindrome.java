package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * Write a function that returns true if the given list is a palindrome, else false.
 *
 * Using Stack takes O(n) and O(n) extra space
 * Reverse LL method takes O(n) and O(1) extra space
 */
public class Palindrome {
    public static void main(String[] args) {
        LinkedList<Character> linkedList = new LinkedList<>();
        Node<Character> head = linkedList.getCharacterLinkedList();

        System.out.println("Printing linked list:");
        LinkedList.printLinkedList(head);

        boolean isPalindrome = isPalindrome(head);
        System.out.println("is Palindrome : " + isPalindrome);
    }

    private static boolean isPalindrome(Node<Character> head) {
        return false;
    }
}
