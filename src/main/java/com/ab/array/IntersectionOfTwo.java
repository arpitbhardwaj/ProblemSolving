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
        int arr1[] = {1, 5, 10, 20, 40, 80};
        int arr2[] = {6, 7, 20, 80, 100};

        System.out.println("Array 1 : " + Arrays.toString(arr1));
        System.out.println("Array 2 : " + Arrays.toString(arr2));
        List<Integer> intersection = getIntersection(arr1,arr2);
        System.out.println("Intersection : " + intersection);
        List<Integer> union = getUnion(arr1,arr2);
        System.out.println("Union : " + union);


        int arr3[] = {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println("Array 3 : " + Arrays.toString(arr3));
        intersection = getIntersection(arr1,arr2,arr3);
        System.out.println("Intersection : " + intersection);
        union = getUnion(arr1,arr2,arr3);
        System.out.println("Union : " + union);
    }

    private static List<Integer> getUnion(int[] arr1, int[] arr2) {
        List<Integer> result =  new ArrayList<>();
        int p1 = 0,p2 = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        while (p1 < n1 && p2 < n2){
            if(arr1[p1] == arr2[p2]){
                result.add(arr1[p1]);
                p1++;
                p2++;
            }
            else if(arr1[p1] < arr2[p2]){
                result.add(arr1[p1++]);
            }else{
                result.add(arr2[p2++]);
            }
        }
        //add remaining ones from first array
        while (p1 < n1){
            result.add(arr1[p1++]);
        }
        //add remaining ones from second array
        while (p2 < n2){
            result.add(arr2[p2++]);
        }
        return result;
    }

    private static List<Integer> getIntersection(int[] arr1, int[] arr2) {
        List<Integer> result =  new ArrayList<>();
        int p1 = 0,p2 = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        while (p1 < n1 && p2 < n2){
            if(arr1[p1] == arr2[p2]){
                result.add(arr1[p1]);
                p1++;
                p2++;
            }
            else if(arr1[p1] < arr2[p2]){
                p1++;
            }else{
                p2++;
            }
        }
        return result;
    }

    private static List<Integer> getUnion(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result =  new ArrayList<>();
        int p1 = 0,p2 = 0,p3=0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;
        while (p1 < n1 && p2 < n2 && p3 < n3){
            if(arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]){
                result.add(arr1[p1]);
                p1++;
                p2++;
                p3++;
            }
            else if (arr1[p1] < arr2[p2]){
                result.add(arr1[p1++]);
            }else if (arr2[p2] < arr3[p3]){
                result.add(arr2[p2++]);
            }else{
                result.add(arr3[p3++]);
            }
        }
        //add remaining ones from first array
        while (p1 < n1){
            result.add(arr1[p1++]);
        }
        //add remaining ones from second array
        while (p2 < n2){
            result.add(arr2[p2++]);
        }

        //add remaining ones from third array
        while (p3 < n3){
            result.add(arr3[p3++]);
        }
        return result;
    }

    private static List<Integer> getIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result =  new ArrayList<>();
        int p1 = 0,p2 = 0,p3=0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;
        while (p1 < n1 && p2 < n2 && p3 < n3){
            if(arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]){
                result.add(arr1[p1]);
                p1++;
                p2++;
                p3++;
            }
            else if(arr1[p1] < arr2[p2]){
                p1++;
            }else if (arr2[p2] < arr3[p3]){
                p2++;
            }else{
                p3++;
            }
        }
        return result;
    }
}
