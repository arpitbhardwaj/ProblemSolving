package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Given arrival and departure times of all trains that reach a railway station,
 * the task is to find the minimum number of platforms required for the railway station so that no train waits.
 *
 * Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
 * dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * Output: 3
 */
public class MinPlatforms {
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int minPlatforms = minPlatforms(arr,dep);
        System.out.println("minimum number of platforms required : " + minPlatforms);
    }

    private static int minPlatforms(int[] arr, int[] dep) {
        int noOfTrains = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platformsNeeded = 1;
        int minPlatforms = 1;

        //logic of merge sort to work with 2 sorted arrays together without merging
        int i = 1;//i for arr indexing (starting from 2nd train arrival)
        int j = 0;//j for dep indexing
        while (i < noOfTrains && j < noOfTrains){
            if(arr[i] < dep[j]){
                platformsNeeded++;
                i++;
                if (platformsNeeded > minPlatforms){
                    minPlatforms = platformsNeeded;
                }
            }else{
                platformsNeeded--;
                j++;
            }
        }

        return minPlatforms;
    }
}
