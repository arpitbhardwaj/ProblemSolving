package com.ab.greedy;

import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int value[] = {100,120,60};
        int weight[] = {20,30,10};
        int capacity = 50;
        int maxValue = fractionalKnapsack(value, weight, capacity);
        System.out.println("Total value obtained: " + maxValue);
    }

    private static int fractionalKnapsack(int[] value, int[] weight, int capacity) {
        List<KnapsackItem> items = new ArrayList<>();
        int totalItems = value.length;
        for (int i = 0; i < totalItems; i++) {
            KnapsackItem item = new KnapsackItem("K" + i, value[i],weight[i]);
            items.add(item);
        }
        items.sort((o1, o2) -> Double.compare(o2.density, o1.density)); //descending order of density
        int usedCapacity = 0;
        int totalValue = 0;
        for (KnapsackItem item : items) {
            if (usedCapacity+item.weight < capacity){
                System.out.println("Taken: " + item);
                usedCapacity += item.weight;
                totalValue += item.value;
            }else if (usedCapacity+item.weight > capacity){
                int leftCapacity = capacity - usedCapacity;
                double extractedValue = item.density * leftCapacity;
                System.out.println("Taken: {" + item.name + ", value=" + extractedValue + ", weight=" + leftCapacity + '}');
                usedCapacity += leftCapacity;
                totalValue += extractedValue;
            }else {
                break;
            }
        }
        return totalValue;
    }

    private static class KnapsackItem{
        public String name;
        public int value;
        public int weight;
        public double density;

        public KnapsackItem(String name, int value, int weight) {
            this.name = name;
            this.value = value;
            this.weight = weight;
            this.density = value * 1.0 / weight;
        }

        @Override
        public String toString() {
            return "{" + name + ", value=" + value + ", weight=" + weight + '}';
        }
    }
}
