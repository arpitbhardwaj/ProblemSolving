package com.ab.queue;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * The LRU caching scheme is to remove the least recently used frame when the cache is full
 * and a new page is referenced which is not there in cache.
 *
 */
public class LRUCache {
    //deque store cached pages size of deque is the size of cache
    private static Deque<Integer> deque;
    // store references of pages in cache (cache dictionary) for simplicity we store pages it self in hash
    private static HashSet<Integer> hashSet;

    // maximum capacity of cache
    private static int cacheSize;

    public LRUCache(int size) {
        deque = new ArrayDeque<>();
        //deque = new LinkedList<>();
        hashSet = new HashSet<>();
        cacheSize = size;
    }

    public void refer(int page){
        //If the required page is not in memory, we bring that in memory.
        if (!hashSet.contains(page)) {
            //the required page is not present in the memory.
            if (deque.size() == cacheSize) {
                int lastPage = deque.removeLast();
                hashSet.remove(lastPage);
            }
        }else{
            // If it is in the memory, we need to detach the node of the list and bring it to the front of the queue.
            Iterator<Integer> iterator = deque.iterator();
            while (iterator.hasNext()){
                if (iterator.next() == page){
                    deque.remove(page);//works same as removeFirstOccurrence
                    break;
                }
            }
        }
        // we add a new node to the front of the queue and update the corresponding node address in the hash
        deque.addFirst(page);
        hashSet.add(page);
    }

    public void display(){
        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next() + " ");
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.refer(1);//1
        lruCache.refer(2);//21
        lruCache.refer(3);//321
        lruCache.refer(1);//132
        lruCache.refer(4);//4132
        lruCache.refer(5);//5413
        lruCache.refer(4);//4513
        lruCache.display();
    }
}
