package com.ab.recursion;

/**
 * @author Arpit Bhardwaj
 *
 * f(n) = f(n-1) + f(n-2)
 *
 * Using Recursion
 *  space complexity is the height of the recursion tree
 * Using Dynamic Programming
 *
 */
public class Fibonacci {
    //seed value
    static int f0 = 0,f1 = 1,fn = 0;

    public static void main(String[] args) {
        System.out.println(fibonacciNumber(9));
        fibonacciSeries(9);
    }

    //linear recursion (very inefficient)
    private static int fibonacciNumber(int n) {
        if(n < 0){
            return -1;
        }
        if (n == 0 || n== 1){
            return n;
        }
        return fibonacciNumber(n-1) + fibonacciNumber(n-2);
    }

    private static void fibonacciSeries(int count) {
        //print seeded values
        System.out.print(f0 + " " + f1 + " ");
        fibonacciSeriesUtil(count - 2);
    }

    private static void fibonacciSeriesUtil(int count) {
        if (count > 0){
            fn = f0 + f1;
            System.out.print(fn + " ");
            f0 = f1;
            f1 = fn;
            fibonacciSeriesUtil(count-1);
        }
    }
}
