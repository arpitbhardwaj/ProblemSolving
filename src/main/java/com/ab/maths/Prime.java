package com.ab.maths;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Prime Numbers
 *      have only two factors 1 and the number itself.
 *
 * Coprime Numbers
 *      are those numbers that donot have any common factors.
 *      any two consecutive numbers are co-prime numbers.
 */

public class Prime {
    public static void main(String[] args) {
        int n = 40;
        System.out.println(isPrime(n));
        listOfPrimes(n);
    }

    private static void listOfPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);//true means number is prime

        for (int i = 2; i*i <= n; i++) {
            if(isPrime[i]){
                //mark all its multiples false
                for (int j = i*2; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]){
                System.out.print(i + " ");
            }
        }

    }

    //O(sqrt(n))
    private static boolean isPrime(int n) {
        if(n<=1){
            return false;
        }
        int i = 2;
        //check only till square root i <= Math.sqrt(n) or square both sides for simplicity
        while (i*i <= n){
            if(n%i == 0){
                return false;
            }
            i++;
        }
        return true;
    }
}
