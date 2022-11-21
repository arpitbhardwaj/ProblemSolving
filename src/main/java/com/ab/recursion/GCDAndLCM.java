package com.ab.recursion;

/**
 * @author Arpit Bhardwaj
 *
 * HCF = Highest common factors.
 * GCD = Greatest common divisor. Names are different otherwise they’re one and same.
 * gcd(4,6) = 2
 *
 * LCM= Lowest common multiple
 * lcm(4,6)=12
 * lcm(7,11,13) = 1001  //lcm of prime numbers is the multiplication of numbers itself
 * lcm(6,7) = 42        //lcm of coprime numbers is the multiplication of numbers itself
 */

public class GCDAndLCM {
    public static void main(String[] args) {
        System.out.println(gcd(4,6));
        System.out.println(lcm(6,7));
    }

    /**
     * Euclidean Algorithm
     * gcd(a,b)=  gcd(b, a%b)
     */
    private static int gcd(int a, int b) {
        if(a < 0 || b < 0){
            return -1;
        }
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }

    /**
     *
     */
    private static int lcm(int a, int b) {
        return a*b / gcd(a,b);
    }
}
