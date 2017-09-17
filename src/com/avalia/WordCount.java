package com.avalia;

/**
 * Created by rahul on 17/9/17.
 */
public class WordCount {
    int count;
    String word;

    public WordCount(String word, int count) {

        this.word = word;
        this.count = count;
    }

    @Override
    public String toString() {
        return word + "->" + count;
    }
}
