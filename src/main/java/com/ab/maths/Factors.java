package com.ab.maths;

public class Factors {
    public static void main(String[] args) {
        printFactors(20);
    }

    private static void printFactors(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n%i == 0){
                if (n/i == i){
                    System.out.print(i+" ");
                }else{
                    System.out.print(i + " " + n/i + " ");
                }
            }
        }
    }
}
