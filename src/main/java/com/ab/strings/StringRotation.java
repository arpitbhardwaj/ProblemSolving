package com.ab.strings;

/**
 * @author Arpit Bhardwaj
 *
 * Given two strings a and b.
 * The task is to find if a string 'a' can be obtained by rotating another string 'b' by 2 places.
 *
 * Input: string1 = “amazon”, string2 = “azonam”
 * Output: Yes
 */
public class StringRotation {
    public static void main(String[] args) {
        String str1 = "amazon";
        //String str2 = "azonam";//anti clockwise rotation
        String str2 = "onamaz";//clockwise rotation
        boolean isRotatedTwice = isRotatedTwice(str1,str2);
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        System.out.println("is String 2 a twice rotated of String 1: " + isRotatedTwice);
    }

    private static boolean isRotatedTwice(String str1, String str2) {
        if (str1.length() != str2.length()){
            return false;
        }
        String clockRot = "";
        String antiClockRot = "";

        int n = str2.length();
        //substring beginIndex inclusive and endIndex exclusive.

        antiClockRot = str2.substring(2, n)
                + str2.substring(0, 2);

        clockRot = str2.substring(n-2, n)
                + str2.substring(0, n-2);

        System.out.println(str1.hashCode());
        System.out.println(clockRot.hashCode());

        return str1.equals(antiClockRot)
                || str1.equals(clockRot);
    }

    //counter clockwise rotation
    public static String leftShift(String str, int shift){
        int length = str.length();
        while (shift > length){
            shift -= length;
        }
        if (shift > 1){
            return str.substring(shift) + str.substring(0,shift);
        }
        //if shift is either 0 or 1 return the same string without any shift
        return str;
    }
    //clockwise rotation
    public static String rightShift(String str, int shift){
        return leftShift(str, str.length() - shift);
    }
}
