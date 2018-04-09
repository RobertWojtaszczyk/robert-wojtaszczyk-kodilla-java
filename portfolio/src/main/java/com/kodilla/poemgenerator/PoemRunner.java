package com.kodilla.poemgenerator;

import java.util.ArrayList;

public class PoemRunner {
    public static void main (String[] args) {
        Poem poem = new Poem();
        ArrayList<String> poem1 = new ArrayList<String>();
        poem1 = poem.generate(50);
        for (String sentence : poem1) {
            System.out.println(sentence);
        }
    }
}
