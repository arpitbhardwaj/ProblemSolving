package com.ab.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 * Given two sorted arrays, find their union and intersection.
 */
public class IntersectionOfTwo {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 4, 5, 6};
        int arr2[] = {2, 3, 5, 7};
        System.out.println("Array 1 : " + Arrays.toString(arr1));
        System.out.println("Array 2 : " + Arrays.toString(arr2));
        List<Integer> intersection = getIntersection(arr1,arr2);
        System.out.println("Intersection : " + intersection);
        List<Integer> union = getUnion(arr1,arr2);
        System.out.println("Union : " + union);
    }

    private static List<Integer> getUnion(int[] arr1, int[] arr2) {
        List<Integer> result =  new ArrayList<>();
        int pointer1 = 0,pointer2 = 0;
        int length1 = arr1.length;
        int length2 = arr2.length;
        while (pointer1 < length1
        && pointer2 < length2){
            if(arr1[pointer1] == arr2[pointer2]){
                result.add(arr1[pointer1++]);
                pointer2++;
            }
            else if(arr1[pointer1] < arr2[pointer2]){
                result.add(arr1[pointer1++]);
            }else{
                result.add(arr2[pointer2++]);
            }
        }
        //add remaining ones from first array
        while (pointer1 < length1){
            result.add(arr1[pointer1++]);
        }
        //add remaining ones from second array
        while (pointer2 < length2){
            result.add(arr2[pointer2++]);
        }
        return result;
    }

    private static List<Integer> getIntersection(int[] arr1, int[] arr2) {
        List<Integer> result =  new ArrayList<>();
        int pointer1 = 0,pointer2 = 0;
        int length1 = arr1.length;
        int length2 = arr2.length;
        while (pointer1 < length1
                && pointer2 < length2){
            if(arr1[pointer1] == arr2[pointer2]){
                result.add(arr1[pointer1++]);
                pointer2++;
            }
            else if(arr1[pointer1] < arr2[pointer2]){
                pointer1++;
            }else{
                pointer2++;
            }
        }
        return result;
    }
}
