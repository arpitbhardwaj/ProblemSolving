package com.ab.misc;

import java.util.Stack;

class DoubleBasePalindrome {
    public static void main(String[] args)
    {
        int sum = 0;
        for(int i=1;i<=10;i++)
        {
            if(isPallindrome(String.valueOf(i)) && isPallindrome(getNumberInGivenBase(i, 2)))
                sum+=i;
        }
        System.out.println(sum);
    }

    public static boolean isPallindrome(String s)
    {
        String reverse = new StringBuffer(s).reverse().toString();
        return s.equals(reverse);
    }
    public static String getNumberInGivenBase(int n, int k)
    {
        Stack<Integer> s = new Stack<Integer>();
        while(n!=0)
        {
            s.push(n%k);
            n/=k;
        }
        StringBuffer sb = new StringBuffer();
        while(!s.isEmpty())
        {
            sb.append(s.pop());
        }
        return new String(sb);
    }
}