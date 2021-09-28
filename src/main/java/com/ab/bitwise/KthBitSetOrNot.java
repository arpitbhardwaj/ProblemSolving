package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 */
public class KthBitSetOrNot {
    public static void main(String[] args) {
        int number = 5;
        int k = 1;
        System.out.println(Integer.toBinaryString(number));
        if (kthLSB(number,k) == 1){
            System.out.println(k + "th LSB Set");
        }else {
            System.out.println(k + "th LSB Not Set");
        }
    }

    public static int kthLSB(int num, int k){
        return (num & (1 << (k-1)));
    }
}
