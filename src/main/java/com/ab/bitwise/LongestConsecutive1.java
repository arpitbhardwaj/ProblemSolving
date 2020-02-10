package com.ab.bitwise;

import com.ab.utils.BitwiseUtils;

/**
 * @author Arpit Bhardwaj
 *
 * Given a number N. The task is to find the length of the longest consecutive 1s in its binary representation.
 */
public class LongestConsecutive1 {
    public static void main(String[] args) {
        //int number = 14;
        int number = 222;
        BitwiseUtils.displayBinary(number);
        System.out.println(String.format("Count of Longest Consecutive Ones in %s are: %s",number
                ,countMaxConsecutiveOnes(number)));
    }

    private static int countMaxConsecutiveOnes(int number) {
        int count = 0;
        while (number != 0){
            //number = number & (number << 1);
            number &= number << 1;
            BitwiseUtils.displayBinary(number);
            count++;
        }
        return count;
    }
}
