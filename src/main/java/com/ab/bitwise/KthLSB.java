package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 */
public class KthLSB {
    public static void main(String[] args) {
        int n = 10;
        int k = 2;
        System.out.println(String.format("Given Number: %s",Integer.toBinaryString(n)));
        if (isKthBitSet(n,k)){
            System.out.println(k + "th bit already set");
            int n1 = resetKthBit(n,k);
            System.out.println(String.format("Number After %snd bit reset: %s",k, Integer.toBinaryString(n1)));
            return;
        }
        int n1 = setKthBit(n,k);
        System.out.println(String.format("Number After %snd bit set: %s",k, Integer.toBinaryString(n1)));
    }
    //1 << (k-1) is called masking
    public static boolean isKthBitSet(int n, int k){
        return (n & (1 << (k-1))) != 0;
    }
    private static int setKthBit(int n, int k) {
        return (n | (1 << (k-1)));
    }
    private static int resetKthBit(int n, int k) { return (n & ~(1 << (k-1))); }
}
