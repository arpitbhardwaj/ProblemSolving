package com.ab.recursion;

/**
 * @author Arpit Bhardwaj
 *
 *  Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle.
 *  The task is to choose the place in the initial circle so that you are the last one remaining and so survive.
 */
public class Josephus {
    public static void main(String[] args) {
        int noOfPersons = 5;
        //int noOfPersons = 14;
        int kthPersonToKill = 2; // (k-1) = 1 will be skipped
        int safePlace = josephus(noOfPersons,kthPersonToKill);
        System.out.println("The Safe Place is: " + safePlace);
    }

    private static int josephus(int noOfPersons, int kthPersonToKill) {
        //base case
        if (noOfPersons == 1){
            return 1;
        }else{
            return (josephus((noOfPersons-1),kthPersonToKill) + (kthPersonToKill - 1)) % noOfPersons + 1;
        }
    }
}
