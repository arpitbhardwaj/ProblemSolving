package com.ab.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * Input: str = “25525511135”
 * Output:
 * 255.255.11.135
 * 255.255.111.35
 *
 * Backtracking is an algorithmic-technique for solving problems recursively by trying to build a solution incrementally,
 * one piece at a time, removing those solutions that fail to satisfy the constraints of the problem at any point of time
 *
 * This is better than naive approach (generating all possible combinations of digits and then trying every combination one by one)
 * as it drops a set of permutations whenever it backtracks.
 */
public class IPAddresses {
    public static void main(String[] args) {
        String str = "25525511135";
        List<String> result = new ArrayList<>();
        generateValidIPAddresses(result, str,0,0,"");
        System.out.println("List of Valid IP Addresses:");
        for (String ipAddress:
             result) {
            System.out.println(ipAddress);
        }
    }

    private static void generateValidIPAddresses(List<String> result, String str, int index, int count, String ipAddress) {

        if (index == str.length() && count == 4){
            ipAddress = ipAddress.substring(0,index+3);
            result.add(ipAddress);
        }

        //base condition
        if (index + 1 > str.length()){
            return;
        }
        //Case 1: select only a single digit, add a dot and move onto selecting other blocks
        ipAddress += str.substring(index,index+1) + ".";
        System.out.println("Case 1: " + ipAddress);
        generateValidIPAddresses(result,str,index+1,count+1,ipAddress);

        ipAddress = ipAddress.substring(0,ipAddress.length() - 2);
        System.out.println("Erase Case 1 : " + ipAddress);

        //base condition
        if (index + 2 > str.length() || str.indexOf(index) == '0'){
            return;
        }
        //Case 2: select two digits at the same time, add a dot and move further.
        ipAddress += str.substring(index,index+2) + ".";
        System.out.println("Going Backtrack to Case 2: " + ipAddress);
        generateValidIPAddresses(result,str,index+2,count+1,ipAddress);

        ipAddress = ipAddress.substring(0,ipAddress.length() - 3);
        System.out.println("Erase Case 2 : " + ipAddress);
        //base condition
        if (index + 3 > str.length() || Integer.parseInt(str.substring(index,index+3)) > 255){
            return;
        }
        //Case 3: select three consecutive digits, add a dot and move further.
        ipAddress += str.substring(index,index+3) + ".";
        System.out.println("Going Backtrack to Case 3: " + ipAddress);
        generateValidIPAddresses(result,str,index+3,count+1,ipAddress);

        ipAddress = ipAddress.substring(0,ipAddress.length() - 4);
        System.out.println("Erase Case 3 : " + ipAddress);
    }
}
