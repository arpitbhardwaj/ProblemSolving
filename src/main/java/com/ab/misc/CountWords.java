package com.ab.misc;

import java.util.stream.Stream;

public class CountWords {
    public static void main(String[] args) {
        String s = "b? Dl )B 4(V! A. MK, YtG ](f 1m )CNxuNUR {PG?";
        System.out.println(countWords(s));

    }

    private static long countWords(String sentence) {
        // Validate the input sentence is not null or empty.
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }
        //b Dl B V A MK YtG f m CNxuNUR PG
        sentence = sentence
                .replaceAll("[.,?!]"," ")
                .replaceAll(" +"," ")
                .trim();
        return Stream.of(sentence.split(" "))
                .filter(w->w.matches("^[-a-zA-Z]*")).count();
    }

}
