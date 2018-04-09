package com.kodilla.linkedlist;

public class Element<T> {
    private T value;
    private Element<T> next = null;
    private Element<T> prev = null;

    public Element (T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public Element<T> getNext() {
        return this.next;
    }

    public Element<T> getPrev() {
        return this.prev;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }

    public void setPrev(Element<T> prev) {
        this.prev = prev;
    }
}