package com.kodilla.poemgenerator;

import java.util.Random;

class AdverbialOfPlace extends Adverbial {
    private String[] adverbialOfPlace = {"w domu","z domu","w pracy","na dworze","na podlodze","w srodku","na zewnatrz","w kolejce","w miescie","na wsi"};
    @Override
    public String generate() {
        Random randomGenerator = new Random();
        int n = randomGenerator.nextInt(10);
        return adverbialOfPlace[n];
    }
}
