package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class MentorQueueTestSuite {

    @Test
    public void testUpdate() {
        //Given
        TraineeHomework johnKovalsky = new TraineeHomework("John Kovalsky");
        TraineeHomework johnNovak = new TraineeHomework("John Novak");
        TraineeHomework tomKovalsky = new TraineeHomework("Tom Kovalsky");
        TraineeHomework tomNovak = new TraineeHomework("Tom Novak");
        TraineeHomework adamSmith = new TraineeHomework("Adam Smith");
        Mentor joeBlack = new Mentor("Joe Black");
        Mentor jackWhite = new Mentor("Jack White");
        johnKovalsky.registerObserver(joeBlack);
        johnNovak.registerObserver(joeBlack);
        tomKovalsky.registerObserver(jackWhite);
        tomNovak.registerObserver(jackWhite);
        adamSmith.registerObserver(jackWhite);
        //When
        johnKovalsky.addHomework("First");
        johnKovalsky.addHomework("Second");
        johnKovalsky.addHomework("Third");
        johnNovak.addHomework("First");
        tomKovalsky.addHomework("First");
        tomNovak.addHomework("First");
        adamSmith.addHomework("First");
        //Then
        assertEquals(4, joeBlack.getUpdateCount());
        assertEquals(3, jackWhite.getUpdateCount());
    }
}