package com.ab.hashing.impl;

import java.util.ArrayList;
import java.util.List;

public class DoubleHashing {
    public static void main(String[] args) {
        HashTable ht = new HashTable(5);
        ht.insert("the");
        ht.insert("quick");
        ht.insert("brown");
        ht.insert("fox");
        ht.display();

        System.out.println(ht.search("quick"));
        ht.delete("quick");
        ht.display();
    }


    private static class HashTable{
        String[] hashTable;
        int usedCellNumber;

        public HashTable(int size){
            this.hashTable = new String[size];
            this.usedCellNumber = 0;
        }

        public int hashFunction1(String value, int M){
            char ch[] = value.toCharArray();
            int sum = 0;
            for (int i = 0; i < value.length(); i++) {
                sum += ch[i];
            }
            return sum % M;
        }

        public int hashFunction2(String value, int M){
            char ch[] = value.toCharArray();
            int sum = 0;
            for (int i = 0; i < value.length(); i++) {
                sum += ch[i];
            }
            while (sum > hashTable.length){
                sum = addAllDigitsTogether(sum);
            }
            return sum % M;
        }

        private int addAllDigitsTogether(int data){
            int value = 0;
            while (data > 0){
                value = data % 10;
                data = data / 10;
            }
            return value;
        }

        private double getLoadFactor(){
            return usedCellNumber * 1.0 / hashTable.length;
        }

        private void rehash(String value){
            usedCellNumber = 0;
            List<String> backupList = new ArrayList<>();
            for (String data : hashTable){
                if (data != null){
                    backupList.add(data);
                }
            }
            backupList.add(value);
            hashTable = new String[hashTable.length * 2];
            for (String data : backupList){
                insert(data);
            }
        }

        void insert(String value){
            if (getLoadFactor() >= 0.75){
                rehash(value);
            }else{
                int index1 = hashFunction1(value, hashTable.length);
                int index2 = hashFunction2(value, hashTable.length);
                System.out.println(index1 + " " + index2);
                for (int i = 0; i < hashTable.length; i++) {
                    int newIndex = (index1 + i*index2) % hashTable.length;
                    if (hashTable[newIndex] == null){
                        hashTable[newIndex] = value;
                        break;
                    }
                }
            }
            usedCellNumber++;
        }

        boolean search(String value){
            //TODO
            return false;
        }

        void delete(String value){
            //TODO
        }

        void display(){
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index: " + i + " Key: " + hashTable[i]);
            }
        }

    }
}
