package com.kodilla.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTestSuite {
    @Test
    public void testAddAndRemoveOneElement() {
        //Given
        Collection<String> collection = new Collection<>();
        collection.add("first");

        //When
        int size = collection.size();
        collection.remove(0);
        //Then
        Assert.assertEquals(1, size);
        Assert.assertEquals(0, collection.size());
        Assert.assertTrue(collection.isEmpty());
    }

    @Test
    public void testAddFewElementsRemoveLast() {
        //Given
        Collection<String> collection = new Collection<>();
        collection.add("first");
        collection.add("second");
        collection.add("third");
        collection.add("fourth");

        //When
        int size = collection.size();
        collection.remove(3);
        String third = collection.get(2);
        //Then
        Assert.assertEquals(4, size);
        Assert.assertEquals(3, collection.size());
        Assert.assertEquals("third", third);
        Assert.assertFalse(collection.isEmpty());
    }

    @Test
    public void testAddFewElementsRemoveMiddleOne() {
        //Given
        Collection<String> collection = new Collection<>();
        collection.add("first");
        collection.add("second");
        collection.add("third");
        collection.add("fourth");

        //When
        collection.remove(1);
        String second = collection.get(1);
        int size = collection.size();
        //Then
        Assert.assertEquals(3, size);
        Assert.assertEquals("third", second);
    }

    @Test
    public void testAddFewElementsRemoveFirst() {
        //Given
        Collection<String> collection = new Collection<>();
        collection.add("first");
        collection.add("second");
        collection.add("third");
        collection.add("fourth");

        //When
        collection.remove(0);
        String first = collection.get(0);
        int size = collection.size();
        //Then
        Assert.assertEquals(3, size);
        Assert.assertEquals("second", first);
    }

    @Test
    public void testPrintWholeCollection() {
        //Given
        Collection<String> collection = new Collection<>();
        collection.add("first");
        collection.add("second");
        collection.add("third");
        collection.add("fourth");

        //When
        int count = 0;
        for (String element : collection) {
//            System.out.println(element);
            count++;
        }
        //Then
        Assert.assertEquals(4, count);
    }

    @Test
    public void testClearCollection() {
        //Given
        Collection<String> collection = new Collection<>();
        collection.add("first");
        collection.add("second");
        collection.add("third");
        collection.add("fourth");

        //When
        collection.clear();
        collection.add("fifth");
        collection.add("sixth");
        collection.add("seventh");

        int count = 0;
        for (String element : collection) {
//            System.out.println(element);
            count++;
        }
        //Then

        Assert.assertEquals(3, count);
        Assert.assertEquals(3, collection.size());
    }
}