package com.kodilla.poemgenerator;

import java.util.Random;

class Predicate extends SentencePart {
    private String[] predicate = {"pracuje","pisze","sprzata","myje","rozmawia","pije","je","czyta","wypoczywa","spi"};
    @Override
    public String generate() {
        Random randomGenerator = new Random();
        int n = randomGenerator.nextInt(10);
        return predicate[n];
    }
}
