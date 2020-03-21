package com.ab.bitwise;

import com.ab.utils.BitwiseUtils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 */
public class KthBitSetOrNot {
    public static void main(String[] args) {
        int number = 5;
        int k = 1;
        System.out.println(Integer.toBinaryString(number));
        if (BitwiseUtils.kthLSB(number,k) == 1){
            System.out.println(k + "th LSB Set");
        }else {
            System.out.println(k + "th LSB Not Set");
        }
    }
}
