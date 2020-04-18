package com.ab.misc;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 * Use Shuffle Mehtod
 * Create your own shuffle implementation
 */
public class RandomizeList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("quiz","arpit","dance","nisha","shashi");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        shuffle(list);
        System.out.println(list);
    }

    private static void shuffle(List<String> list) {
        Random random = new Random();
        for (int i = list.size() - 1; i > 0; i--) {
            int randIndex = random.nextInt(i);
            Collections.swap(list,i,randIndex);
        }
    }
}
