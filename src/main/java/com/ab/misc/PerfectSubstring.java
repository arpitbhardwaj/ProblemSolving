package com.ab.misc;

public class PerfectSubstring {
    public static void main(String[] args) {
        String s = "1102021222";
        int k = 2;
        System.out.println(substrings(s, k));
    }

    static boolean check(int freq[], int k) {
        for (int i = 0; i < 10; i++)
            if (freq[i] != 0 && freq[i] != k)
                return false;
        return true;
    }

    static int substrings(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int freq[] = new int[10];

            // One by one pick ending points
            for (int j = i; j < s.length(); j++) {
                int index = s.charAt(j) - '0';
                freq[index]++;
                if (freq[index] > k)
                    break;
                else if (freq[index] == k &&
                        check(freq, k) == true)
                    res++;
            }
        }
        return res;
    }
}
