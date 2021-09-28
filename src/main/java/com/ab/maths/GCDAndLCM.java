package com.ab.maths;

/**
 * @author Arpit Bhardwaj
 *
 * HCF= Highest common factors.
 * GCD= Greatest common divisor. Names are different otherwise they’re one and same.
 * gcd(4,6) = 2
 *
 * LCM= Lowest common multiple
 * lcm(4,6)=12
 * lcm(7,11,13) = 1001  //lcm of prime numbers is the multiplication of numbers itself
 * lcm(6,7) = 42        //lcm of coprime numbers is the multiplication of numbers itself
 *
 *
 */

public class GCDAndLCM {
    public static void main(String[] args) {
        System.out.println(gcd(4,9));
        System.out.println(lcm(2,7));
    }

    private static int gcd(int a, int b) {
        if(a == 0){
            return b;
        }
        return gcd(b%a,a);
    }

    private static int lcm(int a, int b) {
        return a*b / gcd(a,b);
    }
}
