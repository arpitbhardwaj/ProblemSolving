package com.ab.hashing.impl;

import java.util.LinkedList;

public class DirectChaining {
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
        LinkedList<String>[] hashTable;
        int maxChainSize = 5;

        public HashTable(int size){
            this.hashTable = new LinkedList[size];
        }

        public int hashFunction(String value){
            char ch[] = value.toCharArray();
            int sum = 0;
            for (int i = 0; i < value.length(); i++) {
                sum += ch[i];
            }
            return sum % maxChainSize;
        }

        void insert(String value){
            int index = hashFunction(value);
            if (hashTable[index] == null){
                hashTable[index] = new LinkedList<>();
                hashTable[index].add(value);
            }else{
                hashTable[index].add(value);
            }
        }

        boolean search(String value){
            int index = hashFunction(value);
            return hashTable[index] != null && hashTable[index].contains(value);
        }

        void delete(String value){
            int index = hashFunction(value);
            if (search(value)){
                hashTable[index].remove(value);
            }
        }

        void display(){
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index: " + i + " Key: " + hashTable[i]);
            }
        }

    }
}
