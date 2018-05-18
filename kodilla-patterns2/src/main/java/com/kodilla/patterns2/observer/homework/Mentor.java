package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.Observer;

public class Mentor implements Observer<TraineeHomework> {
    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(TraineeHomework traineeHomework) {
        System.out.println(name + ": New homeworks to check from: " + traineeHomework.getName() + "\n" +
                " (total: " + traineeHomework.getHomeworks().size() + " awaiting)");
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}