package com.ab.misc;

import java.util.*;

public class Janitor {
    public static void main(String[] args) {
        List<Float> weights = new ArrayList<>(List.of(1.99F, 1.01F, 2.5F, 1.5F, 1.01F));
        System.out.println(efficientJanitor(weights));
    }

    public static int efficientJanitor(List<Float> weight) {
        Collections.sort(weight);
        int left = 0;
        int right = weight.size() - 1;
        int count = 0;
        while (left <= right) {
            if (left == right) {
                count++;
                break;
            }
            if (weight.get(left) + weight.get(right) <= 3.0) {
                left++;
                right--;
                count++;
            } else {
                right--;
                count++;
            }
        }
        return count;
    }
}
