package com.kodilla.poemgenerator;

import java.util.ArrayList;

public class Poem {
    ArrayList<String> poem = new ArrayList<String>();
    public ArrayList<String> generate(int rowCount) {
        Sentence sentence = null;
        for (int i = 0; i < rowCount; i++) {
            sentence = new Sentence();
            poem.add(sentence.generate());
        }
        return poem;
    }
}
