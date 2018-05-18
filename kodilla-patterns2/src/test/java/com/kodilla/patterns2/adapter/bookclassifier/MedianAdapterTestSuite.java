package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedianAdapterTestSuite {

    @Autowired
    MedianAdapter medianAdapter;

    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("John Doe1", "Old man and see", 2000, "AAABBB1CCC"));
        bookSet.add(new Book("John Doe2", "Old man and see", 2001, "AAABBB2CCC"));
        bookSet.add(new Book("John Doe3", "Old man and see", 2002, "AAABBB3CCC"));
        bookSet.add(new Book("John Doe4", "Old man and see", 2003, "AAABBB4CCC"));
        bookSet.add(new Book("John Doe5", "Old man and see", 2004, "AAABBB5CCC"));
        //When
        int med = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(2002, med);
    }
}