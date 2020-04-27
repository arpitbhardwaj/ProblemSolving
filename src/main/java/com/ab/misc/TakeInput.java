package com.ab.misc;

import java.util.Scanner;

/**
 * @author Arpit Bhardwaj
 */
public class TakeInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTc = scanner.nextInt();
        for (int i = 1; i <= noOfTc; i++) {
            System.out.println("Enter First TC : " + i);
            scanner.nextLine();
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            char c = scanner.next().charAt(0);
            scanner.nextLine();
            int index = scanner.nextInt();

            System.out.println(str1);
            System.out.println(str2);
            System.out.println(c);
            System.out.println(index);
        }

        scanner.close();
    }
}
