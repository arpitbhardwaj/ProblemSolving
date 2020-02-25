package com.ab.suffixprefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class ZAlgorithm {
    public static void main(String[] args) {
        //String text = "aabxcaabxaabxay";
        //String pattern = "aab";

        String text = "aaabcxyzaaaabczaaczabbaaaaaabc";
        String pattern = "aaabc";

        List<Integer> result = matchPattern(text.toCharArray(),pattern.toCharArray());
        result.forEach(System.out::println);
    }

    private static List<Integer> matchPattern(char[] textCharArr, char[] patternCharArr) {
        int patternLength = patternCharArr.length;
        char[] zArray = new char[textCharArr.length + patternLength + 1];
        int i = 0;
        for (char patternChar:
             patternCharArr) {
            zArray[i] = patternChar;
            i++;
        }
        zArray[i] = '$';
        i++;
        for (char textChar:
             textCharArr) {
            zArray[i] = textChar;
            i++;
        }
        List<Integer> result = new ArrayList<>();
        int[] zIndexArr = calculateZIndex(zArray);

        for (int j = 0; j < zIndexArr.length; j++) {
            if (zIndexArr[j] == patternLength){
                result.add(j - patternLength - 1);
            }
        }
        return result;
    }

    private static int[] calculateZIndex(char[] zArray) {
        System.out.println(zArray);
        int[] zIndexArr = new int[zArray.length];

        int left = 0;
        int right = 0;

        for (int i = 1; i < zArray.length; i++) {
            if (i > right){
                left = right = i;
                while (right < zArray.length
                && zArray[right] == zArray[right-left]){
                    right++;
                }
                zIndexArr[i] = right - left;
                right--;
            }
            else{
                int i1 = i-left;
                //just copy till it reaches right bound of box
                if (zIndexArr[i1] < (right-i+1)){
                    zIndexArr[i] = zIndexArr[i1];
                }
                //check if their are more matches
                else{
                    left = i;
                    while (right < zArray.length
                            && zArray[right] == zArray[right-left]){
                        right++;
                    }
                    zIndexArr[i] = right - left;
                    right--;
                }
            }
        }
        System.out.println(Arrays.toString(zIndexArr));
        return zIndexArr;
    }
}
