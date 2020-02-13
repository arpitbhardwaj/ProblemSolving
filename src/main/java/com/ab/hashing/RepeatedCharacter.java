package com.ab.hashing;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 */
public class RepeatedCharacter {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        char repeatedChar = getFirstRepeatedCharacter(str.toCharArray());
        System.out.println(str);
        System.out.println("The repeated character in above string: " + repeatedChar);
    }

    private static char getFirstRepeatedCharacter(char[] charArr) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < charArr.length; i++) {
            if(charSet.contains(charArr[i])){
                return charArr[i];
            }else{
                charSet.add(charArr[i]);
            }
        }
        return '\0';
    }
}
