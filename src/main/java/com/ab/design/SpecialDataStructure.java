package com.ab.design;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 * Design a data structure that supports the following operations in Θ(1) time.
 * insert(x),remove(x),getRandom(),search(x)
 * use hashing to support first 3 operations and ArrayList together with hashing to support 4th
 */
public class SpecialDataStructure<T> {

    private ArrayList<T> arr;//to store elements
    private HashMap<T,Integer> hash;//keys are array elements and values are indexes

    public SpecialDataStructure() {
        this.arr = new ArrayList<>();
        this.hash = new HashMap<>();
    }

    void insert(T x){
        if (hash.containsKey(x)){
            return;
        }
        int index = arr.size();
        arr.add(x);
        hash.put(x,index);
    }

    void remove(T x){
        Integer index = hash.get(x);
        if (index == null){
            return;
        }
        hash.remove(x);
        int lastIndex = arr.size() - 1;
        T lastElement = arr.get(lastIndex);
        Collections.swap(arr,index, lastIndex);
        arr.remove(lastIndex);
        hash.put(lastElement,index);
    }

    int search(T x){
        if (!hash.containsKey(x)){
            return -1;
        }
        return hash.get(x);
    }

    T getRandom(){
        Random random = new Random();
        int index = random.nextInt(arr.size());
        return arr.get(index);
    }

    public static void main(String[] args) {
        SpecialDataStructure<Integer> specialDS = new SpecialDataStructure<>();
        specialDS.insert(20);
        specialDS.insert(10);
        specialDS.insert(40);
        System.out.println(specialDS.search(10));
        System.out.println(specialDS.search(50));
        specialDS.remove(10);
        specialDS.insert(50);
        System.out.println(specialDS.search(50));
        System.out.println(specialDS.getRandom());
    }
}
