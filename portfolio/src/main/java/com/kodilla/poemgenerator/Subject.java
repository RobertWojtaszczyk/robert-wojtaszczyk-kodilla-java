package com.kodilla.poemgenerator;

import java.util.Random;

class Subject extends SentencePart {
    private String[] subject = {"Mezczyzna","Kobieta","Dziecko","Dziadek","Babcia","Janek","Pies","Kot","Ptaszek","Sasiad"};
    @Override
    public String generate() {
        Random randomGenerator = new Random();
        int n = randomGenerator.nextInt(10);
        return subject[n];
    }
}
