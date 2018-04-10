package com.kodilla.linkedlist;

import java.util.Iterator;

public class Collection<T> implements Iterable<T> {
    private Element<T> collectionHead = null;
    private int size;

    public int getSize() {
        return size;
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

    public boolean remove(int n) {
        checkIndex(n);
        Element<T> temp = collectionHead;

        int rangeCheck = 0;
        while (rangeCheck < n) {
            temp = temp.getNext();
            rangeCheck++;
        }
        if (rangeCheck > 0 && temp.getNext() == null) {
            temp.getPrev().setNext(null);
            size--;
            return true;
        }
        if (n == 0) {
            if (temp.getNext() != null) {
                temp.getNext().setPrev(null);
                collectionHead = temp.getNext();
            } else {
                collectionHead = null;
            }
            size--;
            return true;
        }
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
        size--;
        return true;
    }

    private void checkIndex(int n) {
        if (n >= size) {
            throw new IndexOutOfBoundsException("Index: " + n + ", size: " + size);
        }
    }

    public int size() {
        int rangeCheck;
        Element<T> temp = collectionHead;
        if (collectionHead == null) {
            return 0;
        } else {
            rangeCheck = 1;
            while (temp.getNext() != null) {
                temp = temp.getNext();
                rangeCheck++;
            }
            return rangeCheck;
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

/*
*         public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
*
* */