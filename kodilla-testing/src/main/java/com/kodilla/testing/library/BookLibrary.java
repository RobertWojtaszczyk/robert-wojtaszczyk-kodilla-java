package com.kodilla.testing.library;
import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    LibraryDatabase libraryDatabase;
    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }
    public List<Book> listBooksWithCondition(String titleFragment){ // nie nadpisujemy metod interfejsu? @Override?
        List<Book> bookList = new ArrayList<>(); // ?? <Book> explicit type argument can be replaced with <> ??
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment); //?wstrzykujemy mocka żeby móc wyciągnąć z niego dane?
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }
    public List<Book> listBooksInHandsOf(LibraryUser libraryUser){
        return libraryDatabase.listBooksInHandsOf(libraryUser);
    }
}