package com.ab.greedy;

/**
 * @author Arpit Bhardwaj
 *
 * Find the largest number with given digit sum s and number of digits d?
 * Input  : s = 20, d = 3
 * Output : 992
 */
public class LargestNumber {
    public static void main(String[] args) {
        int sum = 0;
        int digits = 3;
        int largestNumber = getLargestNumber(sum,digits);
        System.out.println(String.format("Largest Number Possible with %s digits and having %s sum if digits : %s"
                ,digits
                ,sum
                ,largestNumber));
    }

    private static int getLargestNumber(int sum, int digits) {
        int resultNumber = 0;
        if (sum == 0){
            if (digits==1){
                return resultNumber;
            }else{
                throw new IllegalArgumentException("Not Possible");
            }
        }
        if(sum > 9*digits){
            throw new IllegalArgumentException("Given sum is greater than maximum possible sum");
        }
        int[] result = new int[digits];
        for (int i = 0; i < digits; i++) {
            if (sum > 9){
                result[i] = 9;
                sum -= 9;
            }
            else {
                result[i] = sum;
                sum = 0;
            }
        }
        for (int i = 0; i < result.length; i++) {
            resultNumber *= 10;
            resultNumber += result[i];
        }
        return resultNumber;
    }
}
