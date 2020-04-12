package com.ab.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 * Given a string str and another string patt. Find the character in patt that is present at the minimum index in str.
 */
public class MinIndexCharacter {
    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String str2 = "zst";
        System.out.println(str1);
        System.out.println(str2);
        char mimIndexChar = getMinIndexCharacter(str1.toCharArray(),str2.toCharArray());
        if(mimIndexChar == '\0'){
            System.out.println("No Character Present");
        }else{
            System.out.println("Character of String 2 present at minimum index in String 1 : " + mimIndexChar);
        }

    }

    private static char getMinIndexCharacter(char[] charArr1, char[] charArr2) {
        Map<Character,Integer> charIndexMap = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < charArr1.length; i++) {
            if(!charIndexMap.containsKey(charArr1[i])){
                charIndexMap.put(charArr1[i], i);
            }
        }
        for (int i = 0; i < charArr2.length; i++) {
            if(charIndexMap.containsKey(charArr2[i])
            && charIndexMap.get(charArr2[i]) < minIndex){
                minIndex = charIndexMap.get(charArr2[i]);
            }
        }
        if(minIndex == Integer.MAX_VALUE){
            return '\0';
        }else{
            return charArr1[minIndex];
        }
    }
}
