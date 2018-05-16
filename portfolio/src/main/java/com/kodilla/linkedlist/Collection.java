package com.kodilla.linkedlist;

import java.util.Iterator;

public class Collection<T> implements Iterable<T> {
    private Element<T> collectionHead = null;
    private int size;

    public int size() {
        return this.size;
    }

    public void add(T e) {
        Element<T> element = new Element<>(e);
        if (collectionHead == null) {
            collectionHead = element;
        } else {
            Element<T> temp = collectionHead;
            while (temp.getNext()!=null) {
                temp = temp.getNext();
            }
            temp.setNext(element);
            element.setPrev(temp);
        }
        size++;
    }

    public T get(int n) {
        checkIndex(n);
        int rangeCheck = 0;
        Element<T> temp = collectionHead;
        while (rangeCheck < n) {
            temp = temp.getNext();
            rangeCheck++;
        }
        return temp.getValue();
    }

    public void clear() {
        collectionHead = null;
        size = 0;
    }

    public void remove(int n) {
        checkIndex(n);
        Element<T> temp = collectionHead;

        int rangeCheck = 0;
        while (rangeCheck < n) {
            temp = temp.getNext();
            rangeCheck++;
        }

        if (rangeCheck > 0 && n == (size - 1)) {
            temp.getPrev().setNext(null);
        } else if (n == 0) {
            if (temp.getNext() != null) {
                temp.getNext().setPrev(null);
                collectionHead = temp.getNext();
            } else {
                collectionHead = null;
            }
        } else {
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int n) {
        if (n >= size || n < 0) {
            throw new IndexOutOfBoundsException("Index: " + n + ", size: " + size);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new CollectionIterator();
    }

    private class CollectionIterator implements Iterator<T> {
        Element<T> cursor = collectionHead;

        @Override
        public boolean hasNext() {
            return cursor != null && cursor.getValue() != null;
        }

        @Override
        public T next() {
            T currentElement = cursor.getValue();
            cursor = cursor.getNext();
            return currentElement;
        }
    }
}