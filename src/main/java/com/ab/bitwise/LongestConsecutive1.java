package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 *
 * Given a number N. The task is to find the length of the longest consecutive 1s in its binary representation.
 */
public class LongestConsecutive1 {
    public static void main(String[] args) {
        //int number = 14;
        int n = 222;
        System.out.println(String.format("Binary of %s is %s",n,Integer.toBinaryString(n)));
        System.out.println(String.format("Count of Longest Consecutive Ones in %s are: %s",n
                ,countMaxConsecutiveOnes(n)));
    }

    private static int countMaxConsecutiveOnes(int n) {
        int count = 0;
        while (n != 0){
            n = n & (n << 1);
            count++;
        }
        return count;
    }
}
