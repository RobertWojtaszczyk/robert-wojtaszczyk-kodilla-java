package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.Observable;
import com.kodilla.patterns2.observer.Observer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TraineeHomework implements Observable {
    private final String name;
    private final List<Observer> observers;
    private final Deque<String> homeworks;

    public TraineeHomework(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
        this.homeworks = new ArrayDeque<>();
    }

    public void addHomework(String homework) {
        homeworks.offer(homework);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public String getName() {
        return name;
    }

    public Deque<String> getHomeworks() {
        return homeworks;
    }
}