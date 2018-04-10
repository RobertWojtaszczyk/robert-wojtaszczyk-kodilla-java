package com.kodilla.linkedlist;

import org.junit.Test;

public class LinkedListTestSuite {
    @Test
    public void testLinkedList() {
        Collection<String> collection = new Collection<>();

        collection.add("first");
        collection.add("second");
        collection.add("third");
        collection.add("fourth");
        System.out.println("Size: " + collection.size() + ":" + collection.getSize());

        for (String element : collection) {
            System.out.println(element);
        }

        System.out.println("Element(0): " + collection.get(0));
        System.out.println("Element(1): " + collection.get(1));
        System.out.println("Removing element(0): " + collection.remove(0));
        System.out.println("Element(0): " + collection.get(0));
        System.out.println("Size: " + collection.size() + ":" + collection.getSize());
        System.out.println("Removing element(2): " + collection.remove(1));
        System.out.println("Size: " + collection.size() + ":" + collection.getSize());
        System.out.println("Removing element(2): " + collection.remove(1));
        System.out.println("Size: " + collection.size() + ":" + collection.getSize());

        //System.out.println("Element(1): " + collection.get(1));


        System.out.println("Removing element(0): " + collection.remove(0));
        System.out.println("Size: " + collection.size() + ":" + collection.getSize());

        collection.add("first");
        collection.add("second");
        collection.add("third");
        collection.add("fourth");
        for (String element : collection) {
            System.out.println(element);
        }
        System.out.println("Size: " + collection.size() + ":" + collection.getSize());
    }
}