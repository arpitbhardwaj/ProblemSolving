package com.ab.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arpit Bhardwaj
 */
public class Conversion {
    public static void main(String[] args) {
        System.out.println(convertDecimalToBinary(505));
    }

    /**
     * f(n) = 10*f(n/2) + n%2
     */
    private static int convertDecimalToBinary(int num) {
        if(num == 0){
            return 0;
        }
        return 10 * convertDecimalToBinary(num / 2) + (num % 2);
    }

    /**
     *
     */
    private static int convertBinaryToDecimal(int num) {
        return 0;
    }

}
