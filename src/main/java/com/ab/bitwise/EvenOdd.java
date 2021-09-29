package com.ab.bitwise;

public class EvenOdd {
    public static void main(String[] args) {
        int n = 1557;
        String res = isOdd(n)?"Odd":"Even";
        System.out.println(String.format("%d is %s", n,res));
    }

    private static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
