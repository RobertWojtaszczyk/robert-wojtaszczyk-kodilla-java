package com.kodilla.patterns2.adapter.bookclassifier.librarya;

import java.util.Objects;

public class Book {
    private final String author;
    private final String title;
    private final int publicationYear;
    private final String signature;

    public Book(final String author, final String title, final int publicationYear, final String signature) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.signature = signature;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getPublicationYear() == book.getPublicationYear() &&
                Objects.equals(getSignature(), book.getSignature());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublicationYear(), getSignature());
    }
}
