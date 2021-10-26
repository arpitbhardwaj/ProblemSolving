package com.ab.binarysearch;

import com.ab.utils.Utils;
/**
 * @author Arpit Bhardwaj
 *
 * There are 2 sorted arrays A and B of size n each.
 * Write an algorithm to find the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n).
 * The complexity should be O(log(n)).
 */
public class MedianOfSortedArrays {
    public static void main(String[] args) {
        int arr1[] = {1, 12, 15, 26, 38};
        int arr2[] = {2, 13, 17, 30, 45};
        int median = getMedian(arr1,arr2);
        System.out.println("Median is : " + median);
    }

    private static int getMedian(int[] arr1, int[] arr2) {
        int endAIndex = arr1.length - 1;
        int endBIndex = arr2.length - 1;
        return getMedianUtil(arr1,arr2,0,0,endAIndex,endBIndex);
    }

    private static int getMedianUtil(int[] arr1, int[] arr2, int startAIndex, int startBIndex, int endAIndex, int endBIndex) {

        //If size of the two arrays is 2 then use below formula to get the median.
        if (endAIndex - startAIndex == 1){
            return (Math.max(arr1[startAIndex],arr2[startBIndex]) + Math.min(arr1[endAIndex],arr2[endBIndex])) / 2;
        }

        //get the median of first and second array
        int m1 = Utils.medianOfSortedArray(arr1,startAIndex,endAIndex);
        int m2 = Utils.medianOfSortedArray(arr2,startBIndex,endBIndex);

        //if m1 equal to m2 then done return either of them
        if (m1 == m2){
            return m1;
        }
        /* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
        else if (m1 < m2){
            return getMedianUtil(arr1,arr2,Utils.medianIndex(startAIndex,endAIndex)
            ,startBIndex,endAIndex,Utils.medianIndex(startBIndex,endBIndex));
        }
        /* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2....] */
        else {
            return getMedianUtil(arr1,arr2,startAIndex
                    ,Utils.medianIndex(startBIndex,endBIndex), Utils.medianIndex(startAIndex,endAIndex),endBIndex);
        }
    }

}
