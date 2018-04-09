package com.kodilla.poemgenerator;

import java.util.Random;

class Adverbial extends SentencePart {
    private String[] adverbialOfTime = {"w tej chwili","obecnie","teraz","nigdy","prawie nigdy","rzadko","czasami","czesto","zwykle","zawsze"};
    @Override
    public String generate() {
        Random randomGenerator = new Random();
        int n = randomGenerator.nextInt(10);
        return adverbialOfTime[n];
    }
}
