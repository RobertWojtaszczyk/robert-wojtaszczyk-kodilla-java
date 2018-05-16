package com.kodilla.poemgenerator;

import java.util.Random;

public class Sentence {
    public String generate() {
        Subject subject = new Subject();
        Predicate predicate = new Predicate();
        Random random = new Random();
        int rodzaj = random.nextInt(3);
        Adverbial adverbial = null;
        switch (rodzaj) {
            case 0: adverbial = new AdverbialOfTime();
                break;
            case 1: adverbial = new AdverbialOfPlace();
                break;
            case 2: adverbial = new AdverbialOfManner();
                break;
        }
        return subject.generate() + " " + predicate.generate() + " " + adverbial.generate();
    }
}
