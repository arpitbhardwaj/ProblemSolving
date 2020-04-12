package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted.
 * If array is already sorted then inversion count is 0.
 * If array is sorted in reverse order that inversion count is the maximum.
 *
 * The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 *
 * Merge Sort willused to solve this
 */
public class InversionsCount {
    public static void main(String[] args) {
        int arr[] = { 1, 20, 6, 4, 5 }; //has 5 inversion count
        System.out.println(Arrays.toString(arr));
        int inversionCount = mergeSortAndCount(arr,0,arr.length-1);
        System.out.println("Inversion Count : " + inversionCount);
    }

    private static int mergeSortAndCount(int[] arr, int low, int high) {
        int count = 0;
        if(low < high) {
            int mid = (low + high) >>> 1;
            count += mergeSortAndCount(arr,low,mid);
            count += mergeSortAndCount(arr,mid+1,high);
            count += mergeAndCount(arr,low,mid,high);
        }
        return count;
    }

    private static int mergeAndCount(int[] arr, int low, int mid, int high) {
        //create two temp arrays
        int n1 = mid - low + 1;//+1 for 0 based indexing
        int n2 = high - mid;

        //copyOfRange has from inclusive and to exclusive
        int[] tempArr1 = Arrays.copyOfRange(arr, low, mid +1);
        int[] tempArr2 = Arrays.copyOfRange(arr, mid+1, high+1);

        //merge temp arrays back into arr[low, high]
        int i=0,j=0;//i for tempArr1 indexing and j for tempArr2 indexing
        int k =low;//k for original array indexing
        int swapCount = 0;
        while (i < n1 && j < n2){
            if(tempArr1[i] < tempArr2[j]){
                arr[k] = tempArr1[i];
                i++;
            }else{
                arr[k] = tempArr2[j];
                swapCount += (mid + 1) - (low + i);//crux of the algorithm
                j++;
            }
            k++;
        }

        //copy remaining elements of temp arrays
        while (i< n1){
            arr[k] = tempArr1[i];
            i++;
            k++;
        }
        while (j < n2){
            arr[k] = tempArr2[j];
            j++;
            k++;
        }
        return swapCount;
    }
}
