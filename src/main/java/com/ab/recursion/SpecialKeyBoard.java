package com.ab.recursion;

/**
 * @author Arpit Bhardwaj
 *
 * Imagine you have a special keyboard with the following keys:
 * Key 1:  Prints 'A' on screen
 * Key 2: (Ctrl-A): Select screen
 * Key 3: (Ctrl-C): Copy selection to buffer
 * Key 4: (Ctrl-V): Print buffer on screen appending it
 *                  after what has already been printed.
 * If you can only press the keyboard for N times (with the above four
 * keys), write a program to produce maximum numbers of A's.
 */
public class SpecialKeyBoard {
    public static void main(String[] args) {
        int keyStrokes = 19;
        int maxAs = maximumAs(keyStrokes);
        System.out.println(String.format("Maximum number of As with %s keystrokes is : %s",keyStrokes,maxAs));
    }

    private static int maximumAs(int keyStrokes) {
        if (keyStrokes <= 6){
            return keyStrokes;
        }
        int max = 0;
        int breakPoint = keyStrokes - 3;
        for (; breakPoint >= 1 ; breakPoint--) {
            int curr = (keyStrokes - breakPoint - 1) * maximumAs(breakPoint);
            if (curr > max){
                max = curr;
            }
        }
        return max;
    }
}
