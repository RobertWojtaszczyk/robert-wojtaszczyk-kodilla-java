package com.kodilla.linkedlist;

import org.junit.Test;

public class LinkedListTestSuite {
    @Test
    public void testLinkedList() {
        Collection<String> collection = new Collection<>();
        collection.add("first");
        collection.add("second");
        System.out.println(collection.get(1));
        System.out.println(collection.get(0));
        System.out.println(collection.size());
        System.out.println(collection.remove(0));
        System.out.println(collection.get(0));
        System.out.println(collection.size());






        /*int numberOfElements = 10;
        //wypełnienie kolekcji
        for (int i = 0; i < numberOfElements; i++) {
            //collection.add(new Element<String>("Test" + i));
            //collection.add(new Element<>(i));
            collection.add(i);
        }
        // wyświetlenie wszystkich elementów kolekcji, w pętli celowo przekraczam zakres
        for (int i = 0; i < collection.size() + 1; i++) {
            System.out.println(collection.get(i));
        }
        System.out.println("Collection size: " + collection.size());
        //test na usuwanie n - tego elementu
        if (collection.remove(8)) {
            System.out.println("\nElement removed successfully. Current collection size is " + collection.size() + ":");
        }
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.get(i));
        }
        //test na usuwanie ostatniego elementu
        if (collection.remove(collection.size()-1)) {
            System.out.println("\nLast element removed successfully. Current collection size is " + collection.size() + ":");
        }
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.get(i));
        }
        //test na usuwanie pierwszego elementu
        if (collection.remove(0)) {
            System.out.println("\nFirst element removed successfully. Current collection size is " + collection.size() + ":");
        }
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.get(i));
        }*/
    }
}
