package com.ab.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 * Given a string str, the task is to print all the permutations of str.
 */
public class Permutations {
    public static void main(String[] args) {
        permutations1("","abc");
        System.out.println();
        System.out.println(permutations2("","abc"));
        System.out.println(countPermutations("","abc"));
    }

    private static void permutations1(String p, String up) {
        if (up.isEmpty()){
            System.out.print(p + " ");
            return;
        }
        char c = up.charAt(0);
        int n = p.length();
        for (int i = 0; i <= n; i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,n);
            permutations1(first+c+second,up.substring(1));
        }
    }

    private static List<String> permutations2(String p, String up) {
        if (up.isEmpty()){
            List<String> potentialAns = new ArrayList<>();
            potentialAns.add(p);
            return potentialAns;
        }
        List<String> localAns = new ArrayList<>();
        char c = up.charAt(0);
        int n = p.length();
        for (int i = 0; i <= n; i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,n);
            List<String> ansFromFuture = permutations2(first+c+second,up.substring(1));
            localAns.addAll(ansFromFuture);
        }

        return localAns;
    }

    private static int countPermutations(String p, String up) {
        if (up.isEmpty()){
            return 1;
        }
        int count = 0;
        char c = up.charAt(0);
        int n = p.length();
        for (int i = 0; i <= n; i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,n);
            count += countPermutations(first+c+second,up.substring(1));
        }
        return count;
    }
}
