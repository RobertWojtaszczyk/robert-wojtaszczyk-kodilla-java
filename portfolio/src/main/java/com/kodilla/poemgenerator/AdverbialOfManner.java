package com.kodilla.poemgenerator;

import java.util.Random;

class AdverbialOfManner extends Adverbial {
    private String[] adverbialOfManner = {"szybko","wolno","mocno","slabo","ospale","leniwie","nerwowo","spokojnie","dlugo","krotko"};
    @Override
    public String generate() {
        Random randomGenerator = new Random();
        int n = randomGenerator.nextInt(10);
        return adverbialOfManner[n];
    }
}
