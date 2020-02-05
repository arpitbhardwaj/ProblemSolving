package com.ab.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 * Given three arrays sorted in non-decreasing order, print all common elements in these arrays.
 */
public class IntersectionOfThree {
    public static void main(String[] args) {
        int arr1[] = {1, 5, 10, 20, 40, 80};
        int arr2[] = {6, 7, 20, 80, 100};
        int arr3[] = {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println("Array 1 : " + Arrays.toString(arr1));
        System.out.println("Array 2 : " + Arrays.toString(arr2));
        System.out.println("Array 3 : " + Arrays.toString(arr3));
        List<Integer> intersection = getIntersection(arr1,arr2,arr3);
        System.out.println("Intersection : " + intersection);
        List<Integer> union = getUnion(arr1,arr2,arr3);
        System.out.println("Union : " + union);
    }

    private static List<Integer> getUnion(int[] arr1, int[] arr2, int[] arr3) {
        return null;
    }

    private static List<Integer> getIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result =  new ArrayList<>();
        int pointer1 = 0,pointer2 = 0,pointer3=0;
        int length1 = arr1.length;
        int length2 = arr2.length;
        int length3 = arr3.length;
        while (pointer1 < length1
                && pointer2 < length2
                && pointer3 < length3){

            if(arr1[pointer1] == arr2[pointer2]
            && arr2[pointer2] == arr3[pointer3]){
                result.add(arr1[pointer1++]);
                pointer2++;
                pointer3++;
            }
            else if(arr1[pointer1] < arr2[pointer2]){
                pointer1++;
            }else if (arr2[pointer2] < arr3[pointer3]){
                pointer2++;
            }else{
                pointer3++;
            }
        }
        return result;
    }
}
