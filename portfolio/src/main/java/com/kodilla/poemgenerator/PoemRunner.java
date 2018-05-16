package com.kodilla.poemgenerator;

import com.kodilla.linkedlist.Collection;

import java.util.List;

public class PoemRunner {
    public static void main (String[] args) {
        Poem poem = new Poem();
//        List<String> poem1;

        Collection<String> poem1;
        poem1 = poem.generate(50);

        for (String sentence : poem1) {
            System.out.println(sentence);
        }
    }
}
