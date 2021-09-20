package com.ab.misc;

public class ProperFractions {
    public static void main(String[] args) {
        ProperFractions a = new ProperFractions();
        System.out.println(a.properFunc(15));
    }

    public int gcd(int a, int b){
        if (b==0) return a;

        return gcd(b,a%b);
    }

    public int properFunc(int den){
        int result = 0;
        for (int i = 1; i < den; i++) {
            if (gcd(den,i)==1)result++;
        }
        return result;
    }
}
