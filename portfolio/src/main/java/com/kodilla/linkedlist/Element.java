package com.kodilla.linkedlist;

public class Element<T> {
    private T value;
    private Element next = null;
    private Element prev = null;

    public Element (T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public Element getNext() {
        return this.next;
    }

    public Element getPrev() {
        return this.prev;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public void setPrev(Element prev) {
        this.prev = prev;
    }
}