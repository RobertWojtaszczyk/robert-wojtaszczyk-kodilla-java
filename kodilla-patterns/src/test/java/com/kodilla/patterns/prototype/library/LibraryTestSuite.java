package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Public Library");
        IntStream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n -> library.getBooks().add(new Book("Title" + n, "Author" + n, LocalDate.now().minusYears(n))));
        // making a shallow copy
        Library shallowCopy = null;
        try {
            shallowCopy = library.shallowCopy();
            shallowCopy.setName("Shallow Copy of Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        // making a deep copy
        Library deepCopy = null;
        try {
            deepCopy = library.deepCopy();
            deepCopy.setName("Deep Copy of Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        library.getBooks().clear();
        //Then
        System.out.println(library);
        System.out.println(shallowCopy);
        System.out.println(deepCopy);
        Assert.assertEquals(0, shallowCopy.getBooks().size());
        Assert.assertEquals(5, deepCopy.getBooks().size());
        Assert.assertEquals(shallowCopy.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepCopy.getBooks(), library.getBooks());
    }
}