package com.ab.hashing.impl;

import java.util.ArrayList;
import java.util.List;

public class QuadraticProbing {
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

        public int hashFunction(String value, int M){
            char ch[] = value.toCharArray();
            int sum = 0;
            for (int i = 0; i < value.length(); i++) {
                sum += ch[i];
            }
            return sum % M;
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
                int counter = 0;
                int index = hashFunction(value, hashTable.length);
                for (int i = index; i < index + hashTable.length; i++) {
                    int newIndex = (index + counter*counter) % hashTable.length;
                    if (hashTable[newIndex] == null){
                        hashTable[newIndex] = value;
                        break;
                    }
                    counter++;
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
