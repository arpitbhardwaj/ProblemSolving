package com.ab.recursion;

public class Basic {
    static int sum = 0;
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(sumOfDigits(1234));
        System.out.println(productOfDigits(1234));
        revNum1(5672);
        System.out.println(sum);
        System.out.println(revNum2(696923));
        System.out.println(isPalindrome(12321));
        System.out.println(countZeroes(105608902));
    }

    private static int countZeroes(int n) {
        return countZeroesUtil(n,0);
    }

    private static int countZeroesUtil(int n, int count) {
        if(n == 0){
            return count;
        }
        if(n%10 == 0){
            return countZeroesUtil(n/10,count+1);
        }
        return countZeroesUtil(n/10,count);
    }

    private static boolean isPalindrome(int n) {
        return n == revNum2(n);
    }

    private static void revNum1(int n) {
        if(n==0){
            return;
        }
        int lastDigit = n%10;
        sum = sum * 10 + lastDigit;
        revNum1(n/10);
    }

    private static int revNum2(int n) {
        int noOfDigits = (int)(Math.log10(n)) + 1;
        return reverseUtil(n,noOfDigits);
    }

    private static int reverseUtil(int n, int noOfDigits) {
        if(n%10==n){
            return n;
        }
        int lastDigit = n%10;
        return lastDigit * (int)Math.pow(10,noOfDigits-1) + reverseUtil(n/10,noOfDigits-1);
    }

    private static int productOfDigits(int n) {
        if(n%10==n){
            return n;
        }
        return (n%10) * productOfDigits(n/10);
    }

    private static int sumOfDigits(int n) {
        if(n==0){
            return 0;
        }
        return (n%10) + sumOfDigits(n/10);
    }

    private static int factorial(int n) {
        if (n==1){
            return n;
        }
        return n * factorial(n-1);
    }
}
