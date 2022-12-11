package com.ab.divideandconquer;

/**
 * @author Arpit Bhardwaj
 *
 * Given a set of items, each with a weight and a value,
 * determine the number of each item to include in a collection (knapsack) so that
 *      the total weight is less than or equal to a given limit
 *      the total value is as large as possible.
 *
 * You cannot break the items.
 */
public class Knapsack {
    public static void main(String[] args) {
        int value[] = {31,26,17,72};
        int weight[] = {3,1,2,5};
        int capacity = 7;
        int maxValue = knapsack(value, weight, capacity, 0);
        System.out.println("Total value obtained: " + maxValue);
    }

    //Divide and Conquer (Recursive)
    private static int knapsack(int[] value, int[] weight, int capacity, int currentItemIndex) {
        if (currentItemIndex >= value.length || capacity <= 0){
            return 0;
        }
        int profit1 = 0;
        if (weight[currentItemIndex] <= capacity){
            profit1 = value[currentItemIndex] + knapsack(value, weight, capacity - weight[currentItemIndex],currentItemIndex+1);
        }
        int profit2 = knapsack(value, weight, capacity,currentItemIndex+1);

        return Math.max(profit1, profit2);
    }
}
