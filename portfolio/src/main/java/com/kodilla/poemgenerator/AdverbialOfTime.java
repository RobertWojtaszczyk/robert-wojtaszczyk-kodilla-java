package com.kodilla.poemgenerator;

import java.util.Random;

class AdverbialOfTime extends Adverbial {
    private String[] adverbialOfTime = {"w tej chwili","obecnie","teraz","nigdy","prawie nigdy","rzadko","czasami","czesto","zwykle","zawsze"};
    @Override
    public String generate() {
        Random randomGenerator = new Random();
        int n = randomGenerator.nextInt(10);
        return adverbialOfTime[n];
    }
}
