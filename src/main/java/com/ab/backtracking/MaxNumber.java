package com.ab.backtracking;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 *
 * Given a positive integer, find maximum integer possible by doing at-most K swap operations on its digits.
 */
public class MaxNumber {
    public static void main(String[] args) {
        int num = 129814999;
        int swap = 4;
        MaxNumber maxNumber = new MaxNumber();
        int max = maxNumber.findMax(num,swap);
        System.out.println(String.format("%s max number after %s swap is: %s",num,swap,max));
    }

    private int findMax(int num, int swap) {
        int[] max = Utils.convertToIntArray(num);
        findMaxUtil(Utils.convertToIntArray(num),swap,max);
        return Utils.convertToInt(max);
    }

    public void findMaxUtil(int[] num, int swap, int[] max) {
        //base condition
        if (swap == 0){
            return;
        }
        int length = num.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                if (num[i] < num[j]){

                    Utils.swapArrayElements(num,i,j);

                    int numTemp = Utils.convertToInt(num);
                    int maxTemp = Utils.convertToInt(max);

                    if (numTemp > maxTemp){
                        for (int k = 0; k < length; k++) {
                            max[k] = num[k];
                        }
                    }

                    findMaxUtil(num,swap-1,max);

                    //backtrack
                    Utils.swapArrayElements(num,i,j);
                }
            }
        }
    }
}
