package com.ab.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 * f(n) = f(n-1) + f(n-2)
 *
 * Using Recursion (Devide and Conquer)
 *  space complexity is the height of the recursion tree
 * Using Dynamic Programming
 *
 */
public class Fibonacci {
    static int f0 = 0,f1 = 1,fn = 0;

    public static void main(String[] args) {
        System.out.println(fibonacciNumber(45));
        System.out.println(fibonacciNumberDPTD(45));
        System.out.println(fibonacciNumberDPBU(45));
        fibonacciSeries(9);
    }

    //Divide and Conquer
    //Tree recursion (very inefficient)
    //the function call itself multiple times, here it calls 2 times so the branches are 2 and depth is n
    //O(2 pow n) exponential time complexity
    //function calls will be in a tree structure with complexity measured as O(branches pow depth)
    private static int fibonacciNumber(int n) {
        if(n < 0){
            return -1;
        }
        if (n == 0 || n== 1){
            return n;
        }
        return fibonacciNumber(n-1) + fibonacciNumber(n-2);
    }

    //fibonacci using DP to solve recursion inefficiency
    //top down memorization (Advanced version of Devide and Conquer)
    private static int fibonacciNumberDPTD(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return fibonacciNumberDPTDUtil(n, memo);
    }

    private static int fibonacciNumberDPTDUtil(int n, Map<Integer, Integer> memo) {
        if(n < 0){
            return -1;
        }
        if (n == 0 || n== 1){
            return n;
        }
        if(!memo.containsKey(n)){
            memo.put(n, fibonacciNumberDPTDUtil(n-1, memo) + fibonacciNumberDPTDUtil(n-2, memo));
        }
        return memo.get(n);
    }

    //bottom up tabulation (to avoid recursion completely)
    private static int fibonacciNumberDPBU(int n) {
        List<Integer> tb = new ArrayList<>();
        tb.add(0);
        tb.add(1);
        for (int i = 2; i <= n; i++) {
            tb.add(tb.get(i-1) + tb.get(i-2));
        }
        return tb.get(n);
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
