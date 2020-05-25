package com.ab.advancedds;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * @author Arpit Bhardwaj
 *
 * Bloom filters are for hash based probabilistic ds for larger datasets which determines whether an element is probably present or definately not.
 * When a Bloom filter says an element is not present it is for sure not present.
 * When Bloom filter says the given element is present it is not 100% sure,
 *
 * Underlaying Data Structure
 * Bit array of size N
 * h number of hash functions
 *
 * Time complexity: O(H), where H is the number of hash functions used
 * Space complexity: 159 Mb (For 40 million data sets)
 * Case of False positive: 1 mistake per 10 million (for H = 23)
 */
public class BloomFilterDemo {
    public static void main(String[] args) {
        BloomFilter<String> blackListedIps = BloomFilter
                .create(Funnels.stringFunnel(Charset.forName("UTF-8")),10000);

        blackListedIps.put("192.170.0.1");
        blackListedIps.put("75.245.10.1");
        blackListedIps.put("10.125.22.20");

        System.out.println(blackListedIps.mightContain("75.245.10.1"));
        System.out.println(blackListedIps.mightContain("101.125.20.22"));
    }
}
