package com.ab.suffixprefix;

/**
 * @author Arpit Bhardwaj
 */
public class KMPSubStringSearch {
    public static void main(String[] args) {
        String text = "techie - coding make easy";
        String pattern = "coding";
        int index = kmpSubStringSearch(text,pattern);
        if (index == -1){
            System.out.println("Pattern not found");
        }else{
            System.out.println("Pattern found at index : " + index);
        }
    }

    private static int kmpSubStringSearch(String text, String pattern) {

        return 0;
    }
}
