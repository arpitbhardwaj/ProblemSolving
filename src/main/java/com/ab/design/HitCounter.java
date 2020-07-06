package com.ab.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author Arpit Bhardwaj
 *
 * hit(timestamp) – Shows a hit at the given timestamp.
 * getHits(timestamp) – Returns the number of hits received in the past 5 minutes (300 seconds) (from currentTimestamp).
 */
public class HitCounter {
    List<Integer> times;
    List<Integer> hits;

    public HitCounter() {
        this.times = new Vector<>(300);
        this.hits = new Vector<>(300);
    }

    void hit(int timestamp){

    }

    int getHits(int timestamp){
       return 0;
    }
}
