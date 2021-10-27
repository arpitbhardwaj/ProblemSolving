package com.ab.maths;

public class ProperFractions {
    public static void main(String[] args) {
        ProperFractions a = new ProperFractions();
        System.out.println(a.properFunc(15));
    }

    public int gcd(int a, int b){
        if (b==0) return a;

        return gcd(b,a%b);
    }

    public int properFunc(int max_d){
        int result = 0;
        for (int i = 1; i < max_d; i++) {
            for(int j = i + 1; j <= max_d; j++)
            {
                if (gcd(i,j)==1)result++;
            }
        }
        return result;
    }
}
