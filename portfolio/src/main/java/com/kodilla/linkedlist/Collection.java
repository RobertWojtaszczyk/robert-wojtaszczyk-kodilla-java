package com.kodilla.linkedlist;

public class Collection<T> {
    private Element collectionHead = null;

    public boolean remove(int n) {
        int rangeCheck = 0;
        Element temp = collectionHead;
        if (collectionHead==null) {
            System.out.println("Collection is empty!");
            return false;
        } else {
            //wyszukanie n - tego elementu
            while (rangeCheck<n && temp.getNext()!=null) {
                temp = temp.getNext();
                rangeCheck++;
            }
            //błąd: n - większe od liczby elementów
            if (temp.getNext()==null && rangeCheck!=n) {
                System.out.println("Index out of scope!");
                return false;
            }
            //usuwanie ostatniego elementu
            if (rangeCheck > 0 && temp.getNext()==null) {
                temp.getPrev().setNext(null);
                return true;
            }
            //usuwanie pierwszego elementu
            if (rangeCheck == 0 && temp.getNext()!=null) {
                temp.getNext().setPrev(null);
                collectionHead = temp.getNext();
                return true;
            }
            ///usuwanie n-tego elementu
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            return true;
        }
    }

    public Element get(int n) {
        int rangeCheck = 0;
        Element temp = collectionHead;
        if (collectionHead==null) {
            return null; //"Collection is empty!"; exception?!
        } else {
            while (rangeCheck<n && temp.getNext()!=null) {
                temp = temp.getNext();
                rangeCheck++;
            }
            if (temp.getNext() == null && rangeCheck != n) {
                System.out.println("Index out of scope!"); //exception
            }
                ; //return "Index out of scope!";}
                return (Element) temp.getValue();
            }
    }

    public void add(Element<T> e) {
        Element element = new Element<>(e);    //?????????????????????? Unchecked call to Element<T>
        if (collectionHead==null) {
            collectionHead = element;
        } else {
            Element temp = collectionHead;
            while (temp.getNext()!=null) {
                temp = temp.getNext();
            }
            temp.setNext(element);
            element.setPrev(temp);
        }
    }

    public int size() {
        int rangeCheck = 0;
        Element temp = collectionHead;
        if (collectionHead==null) {
            return 0;
        } else {
            rangeCheck = 1;
            while (temp.getNext()!=null) {
                temp = temp.getNext();
                rangeCheck++;
            }
            return rangeCheck;
        }
    }
}