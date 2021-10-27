package com.ab.strings;

import com.ab.utils.Utils;
import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Sort Elements in Lexicographical Order (Dictionary Order)
 */
public class LexicographicalSort {
    public static void main(String[] args) {
        String[] words = { "Ruby", "C", "Python", "Java" };
        System.out.println(Arrays.toString(words));
        sortLexicographical(words);
        System.out.println(Arrays.toString(words));
    }

    private static void sortLexicographical(String[] words) {
        int n = words.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (words[i].compareTo(words[j]) > 0){
                    Utils.swapArrElements(words,i,j);
                }
            }
        }
    }
}
