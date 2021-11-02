package com.ab.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringRecursion {
    public static void main(String[] args) {
        skipCharacter("","accbacd",'a');
        System.out.println(skipCharacter("accbacd",'c'));
        System.out.println(skipString("abappbdcappefd","app"));
        allSubSeq("","abc");
        System.out.println(allSubSeq2("","abc"));
    }

    private static void skipCharacter(String p, String up, char skipChar) {
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char currChar = up.charAt(0);
        if (currChar ==skipChar){
            skipCharacter(p,up.substring(1),skipChar);
        }else{
            skipCharacter(p+currChar,up.substring(1),skipChar);
        }
    }

    private static String skipCharacter(String up, char skipChar) {
        if (up.isEmpty()){
            return"";
        }
        char currChar = up.charAt(0);
        if (currChar ==skipChar){
            return skipCharacter(up.substring(1),skipChar);
        }else{
            return currChar+skipCharacter(up.substring(1),skipChar);
        }
    }

    private static String skipString(String up, String skipStr) {
        if (up.isEmpty()){
            return"";
        }
        if (up.startsWith(skipStr)){
            return skipString(up.substring(skipStr.length()),skipStr);
        }else{
            return up.charAt(0)+skipString(up.substring(1),skipStr);
        }
    }

    private static void allSubSeq(String p,String up) {
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char c = up.charAt(0);
        allSubSeq(p+c, up.substring(1));
        allSubSeq(p,up.substring(1));
    }

    private static List<String> allSubSeq2(String p, String up) {
        if (up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char c = up.charAt(0);
        List<String> leftAns = allSubSeq2(p+c, up.substring(1));
        List<String> rightAns = allSubSeq2(p,up.substring(1));
        leftAns.addAll(rightAns);
        return leftAns;
    }
}
