package com.ab.array;

public class MaxPairSumAndProduct {
    public static void main(String[] args) {
        int arr[] = { 8, 4, 45, 6, 10, 8 };
        maxPairSum(arr);

        int arr2[] = { 8, 4, 45, 6, 10, 8 };
        System.out.println(maxPairProduct(arr2));
    }

    private static void maxPairSum(int[] arr) {
        //TODO
    }

    private static String maxPairProduct(int[] arr) {
        int n = arr.length;
        int maxProduct = Integer.MIN_VALUE;
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int product = arr[i]*arr[j];
                if (product > maxProduct){
                    maxProduct = product;
                    res = arr[i] + "," + arr[j];
                }
            }
        }
        return res;
    }
}
