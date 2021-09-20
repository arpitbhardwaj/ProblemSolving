package com.ab.misc;

import java.util.stream.Stream;

public class CountWords {
    public static void main(String[] args) {
        String s = "How many? eggs 649726347 ,are in a half-dozen, 13?";
        System.out.println(countWords(s));

    }

    private static long countWords(String sentence) {
        // Validate the input sentence is not null or empty.
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        sentence = sentence
                .replaceAll("[^-a-zA-Z]"," ")
                .replaceAll(" +"," ")
                .trim();
        String[] str = sentence.split(" ");
        return Stream.of(sentence.split(" "))
                .count();
    }

    private static long countWords(final String sentence, final int minLength) {
        // Validate the input sentence is not null or empty.
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        return Stream.of(sentence.split(" "))
                .filter(word -> word.trim().replaceAll("[^a-zA-Z0-9]", "").length() >= minLength)
                .count();
    }
}
